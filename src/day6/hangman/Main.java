package day6.hangman;

public class Main {

  public static void run() {
    Game game = new Game();
    game.init();
    game.start();
    game.showResult();

  }

  public static void main(String[] args) {
    run();
  }
}
