package week3.day11;

import java.util.*;

public class CommandLine {

  Scanner sc = new Scanner(System.in);
  private String command;
  private String flag;
  private String text;

  public void input() throws IllegalArgumentException {
    System.out.print("posh>");
    String[] input = sc.nextLine().split(" ");

    command = input[0];
    if (input[1] != null) {
      flag = input[1];
    }
    if (input[2] != null) {
      text = input[2];
    }
  }

  public String getCommand() {
    return command;
  }

  public String getFlag() {
    return flag;
  }

  public String getText() {
    return text;
  }


}
