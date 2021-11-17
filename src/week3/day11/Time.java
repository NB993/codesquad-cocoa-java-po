package week3.day11;


import java.time.LocalDate;

public class Time {
  final String[][] timeText;
  LocalDate currentTime;

  public Time() {
    this.timeText = new String[][]{
        {"한", "두", "세", "네", "다", ""},
        {"여", "섯", "일", "곱", "여", "덟"},
        {"아", "홉", "열", "한", "두", "시"},
        {"자", "이", "삼", "사", "오", "분"},
        {"정", "일", "이", "삼", "사", "육"},
        {"오", "오", "칠", "팔", "구", "분"}
    };
    this.currentTime = LocalDate.now();
  }

  public String[][] getTimeText() {
    return timeText;
  }

  public LocalDate getCurrentTime() {
    return currentTime;
  }

  public void setCurrentTime(LocalDate currentTime) {
    this.currentTime = currentTime;
  }
}
