package week4.day16.gui;

import java.awt.*;

public class ScrollBarTest {

  public static void main(String[] args) {
    Frame f = new Frame("scrollbar");
    f.setSize(300, 200);
    f.setLayout(null);

    //방향, 초기값, 스크롤 버튼 크기, 최소값, 최대값
    Scrollbar hor = new Scrollbar(Scrollbar.HORIZONTAL, 0, 50, 0, 100);
    hor.setSize(100, 15);
    hor.setLocation(60, 30);

    Scrollbar ver = new Scrollbar(Scrollbar.VERTICAL, 30, 20, 0, 100);
    ver.setSize(15, 100);
    ver.setLocation(30, 50);

    f.add(hor);
    f.add(ver);
    f.setVisible(true);
  }
}
