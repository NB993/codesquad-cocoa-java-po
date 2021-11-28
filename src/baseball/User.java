package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class User {

  private final Scanner sc = new Scanner(System.in);

  public String inputNumber() throws IllegalArgumentException {
    String answer = "";
    try {
      answer = sc.nextLine();
      Integer.parseInt(answer);
      Set<String> answerSet = new HashSet<>(List.of(answer.split("")));
      if (answer.length() < 3) {
        throw new UnderThreeInputString("세 자리 숫자를 입력해주세요.");
      }
      if (answer.length() == 3 && answerSet.size() < 3) {
        throw new DuplicateNumberException("중복되지 않은 숫자를 입력해 주세요.");
      }
    } catch (NumberFormatException e) {
      throw new NumberFormatException("숫자만 입력해주세요.");
    }
    return answer;
  }

}
