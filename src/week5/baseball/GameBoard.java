package week5.baseball;

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
    String input = computer.askQuestionOf(user);
    if (input.equals("0")) {
      setIsGameGoingOn(false);
      return;
    }
    boolean isAnswerRight = computer.checkIsAnswerCorrect(input);
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
      user.closingScanner();
      setIsGameGoingOn(false);
    }
  }

  private void setIsGameGoingOn(boolean b) {
    isGameGoingOn = b;
  }

}
