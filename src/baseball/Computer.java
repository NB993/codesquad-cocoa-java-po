package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {
  private final List<String> answer;
  private final List<String> numbers;

  public Computer() {
    this.numbers = addNumbers();
    this.answer = makeRandomAnswer();
  }

  private List<String> addNumbers() {
    List<String> numbers = new ArrayList<>();
    numbers.add("1");
    numbers.add("2");
    numbers.add("3");
    numbers.add("4");
    numbers.add("5");
    numbers.add("6");
    numbers.add("7");
    numbers.add("8");
    numbers.add("9");

    return numbers;
  }

  private List<String> makeRandomAnswer() {
    Collections.shuffle(numbers);
    return (List<String>) numbers.stream().limit(3);
  }

  public List<String> getAnswer() {
    return answer;
  }
}
