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

  public void askQuestionOf(User user) {
    System.out.print("1~9 사이의 숫자로 조합된 3자리 숫자를 입력해주세요> ");
    try {
      compareAnswerWithUsers(user.inputNumber());
    } catch (NumberFormatException e) {
      System.out.println("숫자만 입력해주세요.");
      askQuestionOf(user);
    }
  }

  private void compareAnswerWithUsers(String usersAnswer) {
    String[] computersSplitAnswer = answer.split("");
    String[] usersSplitAnswer = usersAnswer.split("");

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
