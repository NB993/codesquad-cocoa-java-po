package day6.hangman;

public class Print {

  String answer;
  String answerBlank;

  public void printUserLife(User user) {
    System.out.println("남은 기회 " + user.getLife() + "회");
  }

  public void printHangman(HangMan hangMan) {
    System.out.println(hangMan);
  }

  public void printAnswerBlank() {
    System.out.println(answerBlank);
  }

  public void addAnswer(String answer) {
    this.answer = answer;
  }

  public void printGotRight(String alphabet) {
    makeBlankVisibleAlphabet(alphabet);
  }
  public void makeBlankVisibleAlphabet(String alphabet) {
    int index = 0;
    String[] dividedAnswerBlank = divideSomeWord(answerBlank, " ");

    while ((index = answer.indexOf(alphabet, index)) > -1) {
      dividedAnswerBlank[index] = alphabet;
      index++;
    }

    answerBlank = String.join(" ", dividedAnswerBlank);
    printAnswerBlank();
  }

  public String[] divideSomeWord(String word, String delimeter) {
    return word.split(delimeter);
  }

  public void makeAnswerBlank() {
    answerBlank = "_ ".repeat(answer.length());
    answerBlank = answerBlank.substring(0, answerBlank.length() - 1);
  }

  public void printHint(String hint) {
    System.out.println(hint);
  }
}
