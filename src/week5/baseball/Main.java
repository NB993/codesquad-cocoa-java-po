package week5.baseball;

public class Main {

  public static void main(String[] args) {
    GameBoard gameBoard = new GameBoard();

    while (gameBoard.isGoingOn()) {
      gameBoard.start();
    }
    System.out.println("게임 종료");
  }
}
