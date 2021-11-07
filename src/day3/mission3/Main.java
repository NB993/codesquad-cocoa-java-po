package day3.mission3;

public class Main {

  public static void run() {
    NumberBoard numberBoard = new NumberBoard();
    Boolean continueGame = true;
    numberBoard.printGameStatus(); //겜 시작할 때 한번 출력해주고.

    while (continueGame) {
      String direction = Prompt.input();

      if (numberBoard.IsMovable(direction)) {
        numberBoard.movePieceOfPuzzle();
        numberBoard.printGameStatus();
      }

      continueGame = numberBoard.isGameStillGoingOn();
    }

  }

  public static void main(String[] args) {
    run();
  }
}
