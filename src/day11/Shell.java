package day11;

import java.io.IOException;
import java.util.Currency;

public class Shell {
  boolean isRunning;
  Path path;
  CommandLine commandLine;
  Commands commands;

  public Shell() {
    this.isRunning = true;
    this.path = new Path();
    this.commandLine = new CommandLine();
    this.commands = new Commands();
  }

  //거대한 컨트롤러 역할 메서드
  public void exec() {
    String command;
    try {
      command = commandLine.input();
    } catch (IOException e) {
      System.out.println("잘못된 입력입니다");
      return;
    }


    if (checkIsCommandExist(command)) {
      createNewProccess();
    };
  }

  private boolean checkIsCommandExist(String command) {
    return commands.getCommands().contains((String) command);
  }

  public void createNewProccess() {

  }

  public void pwd() {

  }

  public void ls() {

  }

}
