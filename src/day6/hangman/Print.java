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
    String[] dividedAnswerBlank = divideSomeWord(answerBlank);
    answerBlank = addStringBetweenEach(dividedAnswerBlank, " ");
    System.out.println(answerBlank);
  }

  public void addAnswer(String answer) {
    this.answer = answer;
  }

  private String addStringBetweenEach(String[] splitWordArr, String addString) {
    return String.join(addString, splitWordArr);
  }

  public void printGotRight(String alphabet) {
    makeBlankVisibleAlphabet(alphabet);
  }
  public void makeBlankVisibleAlphabet(String alphabet) {
    int index = -1;
    String[] dividedAnswerBlank = divideSomeWord(answerBlank);

    while ((index += answer.indexOf(alphabet)) > -1) {
      dividedAnswerBlank[index] = alphabet;
    }

    addStringBetweenEach(dividedAnswerBlank, " ");
    printAnswerBlank();
  }

  public String[] divideSomeWord(String word) {
    return word.split("");
  }

  public void makeAnswerBlank() {
    answerBlank = "_ ".repeat(answer.length());
    answerBlank = answerBlank.substring(0, answerBlank.length() - 1);
  }
}
