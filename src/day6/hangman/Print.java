package day6.hangman;

public class Print {

  String answer;

  public void printUserLife(int life) {
    System.out.println("남은 기회는 : " + life + "개입니다.");
  }

  public void printHangman(HangMan hangMan) {
    System.out.println(hangMan);
  }

  public void printBlankOfAnswerLength(String answer) {
  }

}
