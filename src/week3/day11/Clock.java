package week3.day11;

import java.time.LocalDate;
import java.time.LocalTime;

public class Clock {

  private String[][] time = new String[][]{
      {"한", "두", "세", "네", "다", "섯"},
      {"여", "섯", "일", "곱", "여", "덟"},
      {"아", "홉", "열", "한", "두", "시"},
      {"자", "이", "삼", "사", "오", "십"},
      {"정", "일", "이", "삼", "사", "육"},
      {"오", "오", "칠", "팔", "구", "분"}
  };
  private LocalTime now = LocalTime.now();
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";

  public void print() {
    refreshTime();
    refreshColor();
    changeCurrentTimeColor();
    printCurrentTime();
  }

  public void refreshTime() {
    now = LocalTime.now();
  }

  private void refreshColor() {
    time = new String[][]{
        {"한", "두", "세", "네", "다", "섯"},
        {"여", "섯", "일", "곱", "여", "덟"},
        {"아", "홉", "열", "한", "두", "시"},
        {"자", "이", "삼", "사", "오", "십"},
        {"정", "일", "이", "삼", "사", "육"},
        {"오", "오", "칠", "팔", "구", "분"}
    };
  }

  private void changeCurrentTimeColor() {
    changeHour();
    changeMinute();
  }

  private void changeHour() {
    switch (now.getHour()) {
      case 10:
      case 22:
        time[2][2] = ANSI_GREEN + time[2][2] + ANSI_RESET;
        break;
      case 11:
      case 23:
        time[2][2] = ANSI_GREEN + time[2][2] + ANSI_RESET;
        time[2][3] = ANSI_GREEN + time[2][3] + ANSI_RESET;
        break;
      case 12:
      case 24:
        time[2][2] = ANSI_GREEN + time[2][2] + ANSI_RESET;
        time[2][4] = ANSI_GREEN + time[2][4] + ANSI_RESET;
        break;
      case 1:
        time[0][0] = ANSI_GREEN + time[0][0] + ANSI_RESET;
        break;
      case 2:
        time[0][1] = ANSI_GREEN + time[0][1] + ANSI_RESET;
        break;
      case 3:
        time[0][2] = ANSI_GREEN + time[0][2] + ANSI_RESET;
        break;
      case 4:
        time[0][3] = ANSI_GREEN + time[0][3] + ANSI_RESET;
        break;
      case 5:
        time[0][4] = ANSI_GREEN + time[0][4] + ANSI_RESET;
        time[0][5] = ANSI_GREEN + time[0][5] + ANSI_RESET;
        break;
      case 6:
        time[1][0] = ANSI_GREEN + time[1][0] + ANSI_RESET;
        time[1][1] = ANSI_GREEN + time[1][1] + ANSI_RESET;
        break;
      case 7:
        time[1][2] = ANSI_GREEN + time[1][2] + ANSI_RESET;
        time[1][3] = ANSI_GREEN + time[1][3] + ANSI_RESET;
        break;
      case 8:
        time[1][4] = ANSI_GREEN + time[1][4] + ANSI_RESET;
        time[1][5] = ANSI_GREEN + time[1][5] + ANSI_RESET;
        break;
      case 9:
        time[2][0] = ANSI_GREEN + time[2][0] + ANSI_RESET;
        time[2][1] = ANSI_GREEN + time[2][1] + ANSI_RESET;
        break;
      default:
        break;

    }

    time[2][5] = ANSI_GREEN + time[2][5] + ANSI_RESET;
  }

  private void changeMinute() {
    String minute = Integer.toString(now.getMinute());

    if (minute.length() == 2) {
      tensDigitColor(minute);
      unitDigitColor(minute.substring(1));
    }

    if (minute.length() == 1) {
      unitDigitColor(minute);
    }

    time[5][5] = ANSI_GREEN + time[5][5] + ANSI_RESET;
  }

  private void unitDigitColor(String minute) {
    switch(minute) {
      case "1":
        time[4][1] = ANSI_GREEN + time[4][1] + ANSI_RESET;
        break;
      case "2":
        time[4][2] = ANSI_GREEN + time[4][2] + ANSI_RESET;
        break;
      case "3":
        time[4][3] = ANSI_GREEN + time[4][3] + ANSI_RESET;
        break;
      case "4":
        time[4][4] = ANSI_GREEN + time[4][4] + ANSI_RESET;
        break;
      case "5":
        time[5][1] = ANSI_GREEN + time[5][1] + ANSI_RESET;
        break;
      case "6":
        time[4][5] = ANSI_GREEN + time[4][5] + ANSI_RESET;
        break;
      case "7":
        time[6][2] = ANSI_GREEN + time[6][2] + ANSI_RESET;
        break;
      case "8":
        time[6][3] = ANSI_GREEN + time[6][3] + ANSI_RESET;
        break;
      case "9":
        time[6][4] = ANSI_GREEN + time[6][4] + ANSI_RESET;
        break;
      default:
        break;
    }
  }

  private void tensDigitColor(String minute) {
    switch (minute.substring(0, 1)) {
      case "1":
        time[3][5] = ANSI_GREEN + time[3][5] + ANSI_RESET;
        break;
      case "2":
        time[3][1] = ANSI_GREEN + time[3][1] + ANSI_RESET;
        time[3][5] = ANSI_GREEN + time[3][5] + ANSI_RESET;
        break;
      case "3":
        time[3][2] = ANSI_GREEN + time[3][2] + ANSI_RESET;
        time[3][5] = ANSI_GREEN + time[3][5] + ANSI_RESET;
        break;
      case "4":
        time[3][3] = ANSI_GREEN + time[3][3] + ANSI_RESET;
        time[3][5] = ANSI_GREEN + time[3][5] + ANSI_RESET;
        break;
      case "5":
        time[3][4] = ANSI_GREEN + time[3][4] + ANSI_RESET;
        time[3][5] = ANSI_GREEN + time[3][5] + ANSI_RESET;
        break;
      default:
        break;
    }
  }

  private void printCurrentTime() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < time.length; i++) {
      for (int j = 0; j < time[i].length; j++) {
        sb.append(time[i][j] + " ");
      }
      sb.append("\n");
    }
    System.out.println();
    System.out.println(sb.toString());
    System.out.print("posh>");
  }



}
