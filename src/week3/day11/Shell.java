package week3.day11;

import java.io.File;

public class Shell {

  boolean isRunning;
  Path path;
  CommandLine commandLine;
  Commands commands;
  Thread clockThread;

  public Shell() {
    this.isRunning = true;
    this.path = new Path();
    this.commandLine = new CommandLine();
    this.commands = new Commands();
//    this.clockThread = new Thread(new ClockThread());
//    this.clockThread.setDaemon(true);
  }

  public void exec() {
    commandLine.input();
    String command = commandLine.getCommand();

    if (!checkIsCommandExist(command)) {
      return;
    }

    doTask(command);
  }

  private boolean checkIsCommandExist(String command) {
    if (!commands.getCommands().contains(command)) {
      System.out.println("존재하지 않는 명령어입니다.");
      return false;
    }
    return true;
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
      case "hclock":
        try {
          clock(commandLine.getText());
        } catch (InterruptedException e ) {}
        break;
      case "q":
        isRunning = false;
        break;
      default:
        break;
    }

  }

  private void clock(String flag) throws InterruptedException {
    if (flag.equals("-s")) {
      clockThread = new Thread(new ClockThread());
      clockThread.setDaemon(true);
      clockThread.start();
    }

    if (flag.equals("-q")) {
      clockThread.interrupt();
    }
  }

  private void cd(String directory) {
    String[] direcArr = directory.split("/");
    String currentPath = path.getCurrentPath();

    if (direcArr[0].equals("..")) {

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
