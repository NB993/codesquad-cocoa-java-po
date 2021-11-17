package week3.day11;

import java.util.*;

public class CommandLine {

  Scanner sc = new Scanner(System.in);
  private String[] input;

  public void input() throws IllegalArgumentException {
    System.out.print("posh>");
    input = sc.nextLine().split(" ");
  }

  public String getCommand() {
    return input[0];
  }

  public String getText() {
    return input[1];
  }


}
