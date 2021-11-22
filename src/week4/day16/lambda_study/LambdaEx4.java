package week4.day16.lambda_study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LambdaEx4 {

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      list.add(i);
    }

    list.forEach(i -> System.out.println(i + ",")); //Consumer
    System.out.println();

    list.removeIf(x -> x % 2 == 0 || x % 3 == 0); //Predicate
    System.out.println(list); //[1, 5, 7]

    list.replaceAll(i -> i*10); //UnaryOperator
    System.out.println(list); // [10, 50, 70]

    Map<String, String> map = new HashMap<>();
    map.put("1", "1");
    map.put("2", "2");
    map.put("3", "3");
    map.put("4", "4");

    //Map의 forEach는 인자로 BiConsumer타입을 받음. 위의 list와 비교.
    map.forEach((k,v) -> System.out.println("key: " + k + ", value: " + v));

  }
}
