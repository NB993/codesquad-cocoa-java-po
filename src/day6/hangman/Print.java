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
    addSpaceBetweenEach(answerBlank);
  }

  public void addAnswer(String answer) {
    this.answer = answer;
  }

  public void makeBlankVisibleAlphabet(String alphabet) {
    int index;
    String[] splitedAnswerBlank = answerBlank.split(" ");

    while ((index = answer.indexOf(alphabet)) > -1) {
      splitedAnswerBlank[index] = alphabet;
    }

    addSpaceBetweenEach()
    printAnswerBlank();
  }

  private void addSpaceBetweenEach(String someWord) {
    String[] splitedWord = someWord.split("");
    System.out.println(String.join(" ", splitedWord);
  }

  public void printGotRight(String alphabet) {
    makeBlankVisibleAlphabet(alphabet);
  }

  public String[] splitSomeWord(String word) {
    return word.split("");
  }

  public void makeAnswerBlank() {

    String[] splitedAnswer = addSpaceBetweenEach(answer);
    answerBlank = String.join(" ", splitedAnswer);
  }
}
