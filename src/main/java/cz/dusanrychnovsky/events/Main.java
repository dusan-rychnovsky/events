package cz.dusanrychnovsky.events;

import cz.dusanrychnovsky.events.EventProto.Event;
import cz.dusanrychnovsky.events.EventProto.EventType;
import cz.dusanrychnovsky.events.FunctionProto.Function;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {

  private static EventType[] EVENT_TYPES = EventType.values();
  private static final File INPUT_DIR = new File("C:\\Users\\durychno\\devel\\events\\target\\data");

  private static Random rnd = new Random();

  public static void main( String[] args ) throws IOException {

    long startTime = System.nanoTime();

    List<Function> functions = generateFunctions();
    File[] batches = INPUT_DIR.listFiles();

    Results results = new Results();
    for (File batch : batches) {
      System.out.println("BATCH " + batch);
      processBatch(functions, batch, results);
    }

    long endTime = System.nanoTime();
    System.out.println(formatDuration(endTime - startTime));
    
    System.out.println("DONE");
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

  private static void processBatch(List<Function> functions, File batch, Results acc) throws IOException {
    try (FileInputStream fis = new FileInputStream(batch)) {
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

  private static void processEvent(Function function, Event event, Results acc) {
    if (function.getType() == event.getType()) {
      acc.add(function, event.getTargetId(), 1);
    }
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

  private static class Results {
    private final Map<Function, Map<String, Long>> data = new HashMap<>();

    public void add(Function func, String key, int value) {
      if (!data.containsKey(func)) {
        data.put(func, new HashMap<>());
      }
      Map<String, Long> funcData = data.get(func);
      if (!funcData.containsKey(key)) {
        funcData.put(key, 0L);
      }
      funcData.put(key, value + funcData.get(key));
    }
  }
}
