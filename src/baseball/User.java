package baseball;

import java.util.Scanner;

public class User {
  private final Scanner sc = new Scanner(System.in);

  public String submitAnswer() {
    String answer = "";
    try {
      answer = sc.nextLine();
      Integer.parseInt(answer); //숫자입력 확인 예외처리용도
    } catch (NumberFormatException e) {
      System.out.println("숫자만 입력해주세요.");
    }
    return answer;
  }

  public boolean isReadyForNextGame() {
    String answer = "";
    try {
      answer = sc.nextLine();
      Integer.parseInt(answer);
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }
}
