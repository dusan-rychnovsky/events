package cz.dusanrychnovsky.events;

import cz.dusanrychnovsky.events.EventProto.Event;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BrowseEvents {

  private static final File INPUT_DIR = new File("C:\\Users\\durychno\\devel\\events\\target\\data");

  public static void main(String[] args) {
    readFirstFile();
    System.out.println("DONE");
  }

  private static void readFirstFile() {

    File file = INPUT_DIR.listFiles()[0];
    System.out.println(file);

    try (FileInputStream fis = new FileInputStream(file)) {
      int n = 0;
      while (true) {
        n++;
        Event event = Event.parseDelimitedFrom(fis);
        if (event == null) {
          break;
        }
        else {
          System.out.println(n + ":");
          System.out.println(event);
        }
      }
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  private static void scanFirstRecords() {
    for (File file : INPUT_DIR.listFiles()) {
      System.out.println(file);
      try (FileInputStream fis = new FileInputStream(file)) {
        Event event = Event.parseFrom(fis);
        System.out.println(event);
      }
      catch (IOException ex) {
        ex.printStackTrace();
        return;
      }
    }
  }
}
