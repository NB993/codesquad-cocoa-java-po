package week4.day16.gui;

import java.awt.Choice;
import java.awt.Frame;

public class ChoiceTest {

  public static void main(String[] args) {
    Frame f = new Frame();
    int frameWidth = 300;
    int frameHeight = 200;
    f.setSize(frameWidth, frameHeight);
    f.setLayout(null);

    Choice day = new Choice();
    day.add("월요일");
    day.add("화요일");
    day.add("수요일");
    day.add("목요일");
    day.add("금요일");
    day.add("토요일");
    day.add("일요일");

    day.setSize(100, 50);
    day.setLocation(100, 70);

    f.add(day);
    f.setVisible(true);
  }

}
