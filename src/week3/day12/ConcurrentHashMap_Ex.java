package week3.day12;

import java.sql.SQLOutput;
import java.util.*; //왜 아래 import가 필요한 거지?
import java.util.concurrent.*;

public class ConcurrentHashMap_Ex {

  public static void main(String[] args) {

    Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();
    System.out.println(concurrentHashMap.computeIfAbsent("hi", k -> "there"));

   }
}
