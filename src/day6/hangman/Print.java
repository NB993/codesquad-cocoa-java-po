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

  public void printAnswerBlank() {
    String[] dividedAnswerBlank= divideSomeWord(answerBlank);
    addSpaceBetweenEach(dividedAnswerBlank);
    System.out.println(answerBlank);
  }

  public void addAnswer(String answer) {
    this.answer = answer;
  }

  public void makeBlankVisibleAlphabet(String alphabet) {
    int index;
    String[] dividedAnswerBlank = answerBlank.split(" ");

    while ((index = answer.indexOf(alphabet)) > -1) {
      dividedAnswerBlank[index] = alphabet;
    }

    addSpaceBetweenEach();
    printAnswerBlank();
  }

  private String addSpaceBetweenEach(String[] splitWordArr) {
    return String.join(" ", splitWordArr);
  }

  public void printGotRight(String alphabet) {
    makeBlankVisibleAlphabet(alphabet);
  }

  public String[] divideSomeWord(String word) {
    return word.split("");
  }

  public void makeAnswerBlank() {
    String[] splitedAnswer = divideSomeWord(answer);
    answerBlank = addSpaceBetweenEach(splitedAnswer);
  }
}
