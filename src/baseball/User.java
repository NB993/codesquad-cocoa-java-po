package baseball;

import java.util.Scanner;

public class User {

  private final Scanner sc = new Scanner(System.in);

  public String inputNumber() throws NumberFormatException {
    String answer = sc.nextLine();
    Integer.parseInt(answer);
    return answer;
  }

}
