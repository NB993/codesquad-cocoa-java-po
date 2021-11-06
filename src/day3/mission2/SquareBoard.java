package day3.mission2;

public class SquareBoard {

  private final int BLANK = 0;
  private final int MONSTER = 1;
  private final int MINE = 2;
  private final int CHARACTER = 3;
  private final int[][] board = new int[5][5];
  private int characterX = 2;
  private int characterY = 2;
  private int score = 0;
  private boolean isProgressing = true;

  public SquareBoard() {
    board[characterY][characterX] = CHARACTER;
    putSomeWhereOnBoard(MONSTER);
    putSomeWhereOnBoard(MINE);
  }

  private void putSomeWhereOnBoard(int gameObject) {
    int x = (int) (Math.random() * 5);
    int y = (int) (Math.random() * 5);

    if (getOccupyingObject(x, y) == BLANK) {
      board[y][x] = gameObject;

      return;
    }

    putSomeWhereOnBoard(gameObject);
  }


  private int getOccupyingObject(int x, int y) {
    return board[y][x];
  }

  public void moveCharacter(String direction) {
    int nextX = 0;
    int nextY = 0;

    if (direction.equals("W")) {
      nextX = characterX;
      nextY = characterY - 1;
    }
    if (direction.equals("S")) {
      nextX = characterX;
      nextY = characterY + 1;
    }
    if (direction.equals("A")) {
      nextX = characterX - 1;
      nextY = characterY;
    }
    if (direction.equals("D")) {
      nextX = characterX + 1;
      nextY = characterY;
    }
    if (nextX < 0) {
      nextX = 0;
    }
    if (nextX > 4) {
      nextX = 4;
    }
    if (nextY < 0) {
      nextY = 0;
    }
    if (nextY > 4) {
      nextY = 4;
    }

    board[characterY][characterX] = BLANK;
    board[nextY][nextX] = CHARACTER;
    characterX = nextX;
    characterY = nextY;


    int occupyingObject = getOccupyingObject(nextX, nextY);
    if (occupyingObject == MONSTER) {
      //Monster클래스 만들어서 점수가 다른 몬스터를 생성해보자
      System.out.println("점수 : " + ++score);
      relocateGameObjects();
      return;
    }
    if (occupyingObject == MINE) {
      System.out.println("지뢰를 밟았습니다. 게임 종료. 획득한 스코어:" + score);
      isProgressing = false;
      return;
    }

    return;
  }

  public void printCurrGameStatus() {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == MINE) {
          sb.append("[ ]");
        }
        if (board[i][j] == CHARACTER && isProgressing) {
          sb.append("[C]");
        }
        if (board[i][j] == CHARACTER && !isProgressing) {
          sb.append("[X]");
        }
        if (board[i][j] == MONSTER) {
          sb.append("[M]");
        }
        if (board[i][j] == BLANK) {
          sb.append("[ ]");
        }
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

  private void relocateGameObjects() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == MONSTER || board[i][j] == MINE) {
          board[i][j] = BLANK;
        }
      }
    }

    putSomeWhereOnBoard(MONSTER);
    putSomeWhereOnBoard(MINE);
  }

  public boolean isGameInProgress() {
    return isProgressing;
  }
}
