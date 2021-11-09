package day6.hangman;

import java.util.Arrays;

public class HangMan {
  String currentHangManStack = "";
  String[] hangmanPrintArr = {
    "   ____________",
    "   |          _|_",
    "   |         /   \\",
    "   |        |     |",
    "   |         \\_ _/",
    "   |        ---|---",
    "   |           |",
    "   |          / \\ ",
    "   |         /   \\",
    "___|______"
  };

  public String[] getHangmanPrintArr() {
    return hangmanPrintArr;
  }

  public void stackUpHangMan(int life) {
    currentHangManStack = hangmanPrintArr[life] + "\n" + currentHangManStack;
  }

  @Override
  public String toString() {
        return currentHangManStack;
  }
}
