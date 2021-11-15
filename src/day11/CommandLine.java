package day11;

import java.io.IOException;
import java.util.*;

public class CommandLine {

  Scanner sc = new Scanner(System.in);
  String[] input;

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
