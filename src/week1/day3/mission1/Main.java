package day3.mission1;

import java.util.*;

public class Main {

  private static void run() {
    Prompt prompt = new Prompt();
    List<String> names = prompt.input();

    Indian newBornIndian = new Indian(names);

    prompt.print(newBornIndian);
  }

  public static void main(String[] args) {
    run();
  }

}
