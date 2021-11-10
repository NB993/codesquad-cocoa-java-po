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
//    String[] dividedAnswerBlank = divideSomeWord(answerBlank, " ");
//    answerBlank = addStringBetweenEach(dividedAnswerBlank, " ");
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
    int index = 0;
    String[] dividedAnswerBlank = divideSomeWord(answerBlank, " ");

//    while ((index += answer.indexOf(alphabet)) > -1) {
    while ((index = answer.indexOf(alphabet, index)) > -1) {
      dividedAnswerBlank[index] = alphabet;
      System.out.println("이 인덱스에서 알파벳이 일치함: " + index);
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
}
