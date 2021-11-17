package week3.day11;

import java.time.LocalDate;

public class Clock {
  private final String[][] time = new String[][]{
      {"한", "두", "세", "네", "다", ""},
      {"여", "섯", "일", "곱", "여", "덟"},
      {"아", "홉", "열", "한", "두", "시"},
      {"자", "이", "삼", "사", "오", "분"},
      {"정", "일", "이", "삼", "사", "육"},
      {"오", "오", "칠", "팔", "구", "분"}
  };
  private LocalDate now = LocalDate.now();


  //TODO: 임시로 LocalDate로 시간 출력. 향후 삭제
  public void print()  {
    System.out.println(LocalDate.now());
    System.out.print("posh>");
//    changeCurrentTimeColor();
//    printCurrentTime();
  }

  //TODO: 현재 시간 색깔 바꾸기 구현
  private void changeCurrentTimeColor() {
    changeHour();
    changeMinute();
  }

  private void changeMinute() {
  }

  private void changeHour() {
  }

  private void printCurrentTime() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < time.length; i++) {
      for (int j = 0; j < time[i].length; j++) {
        sb.append(time[i][j] + " ");
      }
      sb.append("\n");
    }
    System.out.println(sb.toString());
  }

  public void refreshTime() {
    now = LocalDate.now();
  }

}
