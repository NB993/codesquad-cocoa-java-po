package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {

  private String answer;
  private final List<String> numbers;
  private int strike;
  private int ball;

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

  private String makeRandomAnswer() {
    Collections.shuffle(numbers);
    return numbers.get(0) + numbers.get(1) + numbers.get(2);
  }

  public String askQuestionOf(User user) {
    System.out.print("1~9사이의 중복되지 않은 3자리 숫자를 입력해주세요(종료: 0)> ");
    String userInput = "";
    try {
      userInput = user.inputNumber();
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return askQuestionOf(user);
    }
    return userInput;
  }

  private void compareAnswerWithUserInput(String input) {
    String[] computersSplitAnswer = answer.split("");
    String[] usersSplitAnswer = input.split("");

    for (int i = 0; i < 3; i++) {
      writeDownCount(computersSplitAnswer[i], usersSplitAnswer[i]);
    }
  }

  public void resetCount() {
    strike = 0;
    ball = 0;
  }

  private void writeDownCount(String answerNumber, String usersNumber) {
    if (answerNumber.equals(usersNumber)) {
      strike++;
    }
    if (!answerNumber.equals(usersNumber) && answer.contains(usersNumber)) {
      ball++;
    }
  }

  public boolean checkIsAnswerCorrect(String input) {
    compareAnswerWithUserInput(input);
    if (getStrike() == 3) {
      System.out.println(getAnswer() + "... 정답입니다!");
      resetCount();
      return true;
    }
    if (getStrike() == 0 && getBall() == 0) {
      System.out.println("낫싱!");
      resetCount();
      return false;
    }
    System.out.println(getStrike() + "스트라이크 " + getBall() + "볼");
    resetCount();
    return false;
  }

  public int getStrike() {
    return strike;
  }

  public int getBall() {
    return ball;
  }

  public String getAnswer() {
    return answer;
  }

  public void reset() {
    answer = makeRandomAnswer();
  }

}
