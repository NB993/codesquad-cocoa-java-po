package day3.mission3;

public class NumberBoard {
  private final int[][] BOARD = new int[5][5];
  private boolean isGameGoingOn;
  private int blankX;
  private int blankY;

  public NumberBoard() {
    isGameGoingOn = true;
    initializeBoard();
    shuffle();
  }

  private void initializeBoard() {
    int count = 1;

    for (int i = 0; i < BOARD.length; i++) {
      for (int j = 0; j < BOARD[i].length - 1; i++) {
        BOARD[i][j] = count++;
      }
    }

    blankX = 5;
    blankY = 5;
    BOARD[blankY][blankX] = 0;
  }

  private void shuffle() {

  }

  public Boolean IsMovable(String direction) {
    int movingNumberX = 0;
    int movingNumberY = 0;

    //방향키 입력 받아서 빈칸과 숫자의 위치를 바꿈. 근데 움직이는 놈은 빈칸 사방으로 인접한 번호.
    if (direction.equals("W")) { //빈칸 바로 아래를 찾아냄.
      movingNumberX = blankX;
      movingNumberY = blankY + 1;

//      blankY = blankY + 1;
    }
    if (direction.equals("S")) { // ...
      movingNumberX = blankX;
      movingNumberY = blankY - 1;
    }
    if (direction.equals("A")) { //빈칸 오른쪽의 인덱스를 찾아냄
      movingNumberX = blankX + 1;
      movingNumberY = blankY;
    }
    if (direction.equals("D")) { // ...
      movingNumberX = blankX - 1;
      movingNumberY = blankY;
    }

    if (movingNumberX < 0) {
      System.out.println("왼쪽에는 움직일 수 있는 블록이 없습니다. 다른 방향의 번호를 이동시켜주세요");
      return false;
    }
    if (movingNumberX > 4) {
      System.out.println("오른쪽에는 움직일 수 있는 블록이 없습니다. 다른 방향의 번호를 이동시켜주세요");
      return false;
    }
    if (movingNumberY < 0) {
      System.out.println("위에는 움직일 수 있는 블록이 없습니다. 다른 방향의 번호를 이동시켜주세요");
      return false;
    }
    if (movingNumberY > 4) {
      System.out.println("아래에는 움직일 수 있는 블록이 없습니다. 다른 방향의 번호를 이동시켜주세요");
      return false;
    }
    
    return true;
  }

  public void movePieceOfPuzzle() {


  }

  public void printGameStatus() {
  }




  public Boolean isGameStillGoingOn() {
    return isGameGoingOn;
  }

}
