package day6.hangman;

public class Print {

  String answer;
  String answerBlank;

  public void printUserLife(int life) {
    System.out.println("남은 기회는 : " + life + "개입니다.");
  }

  public void printHangman(HangMan hangMan) {
    System.out.println(hangMan);
  }

  public void printAnswerBlank(String answer) {

    addSpaceBetweenEach();
  }

  public void retainAnswer(String answer) {
    this.answer = answer;
  }

  public void makeBlankVisibleAlphabet(String alphabet) {
    int index;

    while ((index = answer.indexOf(alphabet)) > -1) {
      answerBlank
    }
  }

  private void addSpaceBetweenEach() {
    String[] splitedAnswerBlank = answerBlank.split("");

    System.out.println(String.join(" ", splitedAnswerBlank);
  }

  public void printGotRight(String alphabet) {
    makeBlankVisibleAlphabet(alphabet);
  }

  public void makeAnswerBlank() {
    String[] splitedAnswer = answer.split("");
    answerBlank = String.join(" ", splitedAnswer);
  }
}
