package cz.dusanrychnovsky.events;

import cz.dusanrychnovsky.events.EventProto.Event;
import cz.dusanrychnovsky.events.EventProto.EventType;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class GenerateEvents {

  private static final int NUM_BATCHES = 1000;
  private static final int NUM_PER_BATCH = 10000;
  private static final int NUM_TARGETS = 10000;
  private static EventType[] EVENT_TYPES = EventType.values();
  private static final File OUTPUT_DIR = new File("C:\\Users\\durychno\\devel\\events\\target\\data");

  private static Random rnd = new Random();

  public static void main(String[] args) {
    OUTPUT_DIR.mkdirs();
    int n = 0;
    for  (int b = 0; b < NUM_BATCHES; b++) {
      System.out.println("BATCH " + (b + 1));
      try (FileOutputStream fos = new FileOutputStream(OUTPUT_DIR + "\\data-" + b)) {
        for (int i = 0; i < NUM_PER_BATCH; i++) {
          n++;
          Event event = generateEvent(n);
          event.writeDelimitedTo(fos);
        }
      }
      catch (IOException ex) {
        ex.printStackTrace();
        return;
      }
    }
  }

  private static Event generateEvent(int n) {
    return Event.newBuilder()
      .setId("" + n)
      .setType(EVENT_TYPES[rnd.nextInt(EVENT_TYPES.length)])
      .setTargetId("" + rnd.nextInt(NUM_TARGETS))
      .build();
  }
}
