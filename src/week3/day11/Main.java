package week3.day11;

public class Main {

  public static void main(String[] args) {
    run();
  }

  public static void run() {
    Shell shell = new Shell();

    while (shell.isRunning) {
      shell.exec();
    }

  }
}
