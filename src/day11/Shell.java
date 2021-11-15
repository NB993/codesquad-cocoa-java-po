package day11;

import java.io.File;

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
    commandLine.input();

    String command = commandLine.getCommand();
    if (!checkIsCommandExist(command)) {
      System.out.println("존재하지 않는 명령어입니다.");
      return;
    }

    doTask(command);
  }

  private boolean checkIsCommandExist(String command) {
    return commands.getCommands().contains(command);
  }

  private void doTask(String command) {
    switch (command) {
      case "ls":
        ls();
        break;
      case "pwd":
        pwd();
        break;
      case "cd":
        cd(commandLine.getText());
        break;
      default:
        break;
    }

  }

  private void cd(String directory) {
    String[] direcArr = directory.split("/");
    String currentPath = path.getCurrentPath();

    if (direcArr[0].equals("..")) {
//      currentPath.substring(0, currentPath.lastIndexOf())
    }

  }

  public void pwd() {
    System.out.println(path.getCurrentPath());
  }

  public void ls() {
    File currrentPathDir = new File(path.getCurrentPath());
    File[] files = currrentPathDir.listFiles();
    if (files != null) {
      for (int i = 0; i < files.length; i++) {
        printFile(files[i]);
      }
    }
  }

  private void printFile(File file) {
    String fileName = file.getPath().substring(file.getPath().lastIndexOf("/") + 1);
    if (file.isDirectory()) {
      fileName = fileName + "/";
    }
    System.out.println(fileName);
  }

}
