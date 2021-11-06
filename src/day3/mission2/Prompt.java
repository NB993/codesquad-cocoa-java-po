package day3.mission2;

import java.util.*;

public class Prompt {
  static final SquareBoard squareBoard = new SquareBoard();
  static final Scanner sc = new Scanner(System.in);

  public static boolean input() {
    String direction = sc.nextLine().toUpperCase();
    squareBoard.moveCharacter(direction);
    squareBoard.printCurrGameStatus();

    return squareBoard.isGameInProgress();
  }
}
