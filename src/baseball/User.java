package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class User {

  private final Scanner sc = new Scanner(System.in);

  public String inputNumber() throws IllegalArgumentException {
    String answer = sc.nextLine();
    inputValidateCheck(answer);
    return answer;
  }

  private void inputValidateCheck(String answer) throws IllegalArgumentException {
    checkIfInputHasNumberOnly(answer);
    checkIfInputLengthIsThree(answer);
    checkIfInputHasDulplicateNumber(answer);
  }

  private void checkIfInputHasDulplicateNumber(String answer) {
    Set<String> answerSet = new HashSet<>(List.of(answer.split("")));
    if (answer.length() == 3 && answerSet.size() < 3) {
      throw new DuplicateNumberException("중복되지 않은 숫자를 입력해 주세요.");
    }
  }

  private void checkIfInputLengthIsThree(String answer) throws UnderThreeInputString {
    if (!answer.equals("0") && answer.length() < 3) {
      throw new UnderThreeInputString("세 자리 숫자를 입력해주세요.");
    }
  }

  private void checkIfInputHasNumberOnly(String answer) throws NumberFormatException {
    try {
      Integer.parseInt(answer);
    } catch (NumberFormatException e) {
      throw new NumberFormatException("숫자만 입력해주세요.");
    }
  }

}
