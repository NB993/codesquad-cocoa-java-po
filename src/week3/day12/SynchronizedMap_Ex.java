package week3.day12;

import java.util.*;

public class SynchronizedMap {

  public static void main(String[] args) {
    Map<String, String> normalHashMap = new HashMap<>();
    normalHashMap.put("goodBye", "seeYa");

    Map<String, String> syncMap = Collections.synchronizedMap(normalHashMap);
    System.out.println(syncMap.get("goodBye"));
  }
}
