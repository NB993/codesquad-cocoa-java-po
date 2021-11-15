package day11;

import java.util.*;

public class Commands {
  List<String> commands;

  public Commands() {
    List<String> commands = new ArrayList<>();
    commands.add("ls");
    commands.add("pwd");
    commands.add("cd");

    this.commands = commands;
  }

  public List<String> getCommands() {
    return commands;
  }
}
