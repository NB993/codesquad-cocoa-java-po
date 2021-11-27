package baseball;

public class Main {

  public static void main(String[] args) {
    GameBoard gameBoard = new GameBoard();

    while (gameBoard.isGoingOn()) {
      gameBoard.start();
    }
  }
}
