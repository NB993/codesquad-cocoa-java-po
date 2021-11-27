package baseball;

public class GameBoard {
  private boolean isGameGoingOn;
  private final User user;
  private final Computer computer;

  public GameBoard() {
    this.isGameGoingOn = true;
    this.user = new User();
    this.computer = new Computer();
  }

  public boolean isGoingOn() {
    return isGameGoingOn;
  }

  public void start() {
    computer.askQuestionOf(user);
    printAnswerCount();
  }

  private void printAnswerCount() {
    if (computer.getStrike() == 3) {
      System.out.println(computer.getAnswer() + "... 정답입니다!");
      isGameGoingOn = false;
      return;
    }
    if (computer.getStrike() == 0 && computer.getBall() == 0) {
      System.out.println("낫싱!");
      return;
    }
    System.out.println(computer.getStrike() + "스트라이크 " + computer.getBall() + "볼");
  }

}
