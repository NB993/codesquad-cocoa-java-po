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
    String answer = computer.askQuestionOf(user);
    if (answer.equals("0")) {
      setIsGameGoingOn(false);
      return;
    }
    boolean isAnswerRight = computer.checkIsAnswerCorrect();
    if (isAnswerRight) {
      askIfUserWantNextGame(user);
    }
  }

  private void askIfUserWantNextGame(User user) {
    try {
      System.out.print("다음 게임을 진행하시려면 아무 숫자나 눌러주세요.");
      user.inputNumber();
      computer.reset();
    } catch (NumberFormatException e) {
      System.out.println("게임종료");
      setIsGameGoingOn(false);
    }
  }

  private void setIsGameGoingOn(boolean b) {
    isGameGoingOn = b;
  }

  private void checkIsAnswerCorrect() {
    if (computer.getStrike() == 3) {
      System.out.println(computer.getAnswer() + "... 정답입니다!");
      askIfUserWantNextGame(user);
      computer.resetCount();
      return;
    }
    if (computer.getStrike() == 0 && computer.getBall() == 0) {
      System.out.println("낫싱!");
      computer.resetCount();
      return;
    }
    System.out.println(computer.getStrike() + "스트라이크 " + computer.getBall() + "볼");
    computer.resetCount();
  }

}
