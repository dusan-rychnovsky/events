package cz.dusanrychnovsky.events;

import cz.dusanrychnovsky.events.EventProto.Event;
import cz.dusanrychnovsky.events.EventProto.EventType;
import cz.dusanrychnovsky.events.FunctionProto.Function;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

public class Main {

  private static Random rnd = new Random();

  private static final int NUM_WORKERS = Runtime.getRuntime().availableProcessors() * 2;
  private static final EventType[] EVENT_TYPES = EventType.values();
  private static final List<Function> FUNCTIONS = generateFunctions();
  private static final File INPUT_DIR = new File("C:\\Users\\durychno\\devel\\events\\target\\data");

  public static void main( String[] args ) throws IOException, InterruptedException {

    long startTime = System.nanoTime();

    System.out.println("WORKERS: " + NUM_WORKERS);

    BlockingQueue<Batch> batches = new ArrayBlockingQueue<>(1000 + NUM_WORKERS);
    List<File> files = Arrays.asList(INPUT_DIR.listFiles());
    for (File file : files) {
      batches.add(Batch.get(file));
    }
    for (int i = 0; i < NUM_WORKERS; i++) {
      batches.add(Batch.poisonPill());
    }

    List<Result> results = new ArrayList<>(NUM_WORKERS);

    ExecutorService executor = Executors.newCachedThreadPool();
    for (int i = 0; i < NUM_WORKERS; i++) {
      Result result = new Result();
      results.add(result);
      executor.execute(new Counter("" + i, batches, FUNCTIONS, result));
    }

    executor.shutdown();
    executor.awaitTermination(10L, TimeUnit.MINUTES);

    mergeResults(results);

    long endTime = System.nanoTime();
    System.out.println(formatDuration(endTime - startTime));
    
    System.out.println("DONE");
  }

  private static Result mergeResults(List<Result> results) {
    Result result = new Result();
    for (Result r : results) {
      result.add(r);
    }
    return result;
  }

  private static List<Function> generateFunctions() {
    List<Function> result = new ArrayList<>(1000);
    for (int i = 0; i < 1000; i++) {
      result.add(function(EVENT_TYPES[rnd.nextInt(EVENT_TYPES.length)]));
    }
    return result;
  }

  private static Function function(EventType type) {
    return Function.newBuilder().setType(type).setOperation("count").build();
  }

  private static String formatDuration(long ns) {
    long hours = TimeUnit.NANOSECONDS.toHours(ns);
    ns -= hours * 60 * 60 * 1_000_000_000;
    long minutes = TimeUnit.NANOSECONDS.toMinutes(ns);
    ns -= minutes * 60 * 1_000_000_000;
    long seconds = TimeUnit.NANOSECONDS.toSeconds(ns);
    ns -= seconds * 1_000_000_000;
    long milliseconds = TimeUnit.NANOSECONDS.toMillis(ns);

    return
      hours + "h " +
      minutes + "m " +
      seconds + "s " +
      milliseconds + "ms";
  }

  private static class Batch {

    private final File file;

    public static Batch get(File file) {
      return new Batch(file);
    }

    public static Batch poisonPill() {
      return new Batch(null);
    }

    private Batch(File file) {
      this.file = file;
    }

    public boolean isPoisonPill() {
      return file == null;
    }

    public File getFile() {
      return file;
    }
  }

  private static class Result {
    private final Map<Function, Map<String, Long>> data = new HashMap<>();

    public void add(Function func, String key, long value) {
      if (!data.containsKey(func)) {
        data.put(func, new HashMap<>());
      }
      Map<String, Long> funcData = data.get(func);
      if (!funcData.containsKey(key)) {
        funcData.put(key, 0L);
      }
      funcData.put(key, value + funcData.get(key));
    }

    public void add(Result other) {
      for (Function func : other.data.keySet()) {
        Map<String, Long> funcData = other.data.get(func);
        for (String key : funcData.keySet()) {
          add(func, key, funcData.get(key));
        }
      }
    }
  }

  private static class Counter implements Runnable {

    private final String name;
    private final BlockingQueue<Batch> queue;
    private final List<Function> functions;
    private final Result result;

    private Counter(String name, BlockingQueue<Batch> queue, List<Function> functions, Result result) {
      this.name = name;
      this.queue = queue;
      this.functions = functions;
      this.result = result;
    }

    @Override
    public void run() {
      try {
        while (true) {
          Batch batch = queue.take();
          if (batch.isPoisonPill()) {
            break;
          }

          processFile(batch.getFile(), functions, result);
        }
      }
      catch (Exception ex) {
        ex.printStackTrace();
      }
    }

    private void processFile(File file, List<Function> functions, Result acc)
      throws IOException {
      System.out.println("WORKER " + name + " => BATCH " + file);
      try (FileInputStream fis = new FileInputStream(file)) {
        while (true) {
          Event event = Event.parseDelimitedFrom(fis);
          if (event == null) {
            break;
          }

          for (Function function : functions) {
            processEvent(function, event, acc);
          }
        }
      }
    }

    private static void processEvent(Function function, Event event, Result acc) {
      if (function.getType() == event.getType()) {
        acc.add(function, event.getTargetId(), 1);
      }
    }
  }
}
