package week4.day16.gui;

import java.awt.*;

public class CanvasTest {

  public static void main(String[] args) {
    Frame f = new Frame();
    int frameWidth = 300;
    int frameHeight = 200;
    f.setSize(frameWidth, frameHeight);
    f.setLayout(null);

    Canvas c = new Canvas();
    c.setBackground(Color.pink); //캔버스 컴포넌트 색깔
    c.setBounds(60, 80, 200, 90); //캔버스가 그려질 위치, 크기

    f.add(c);
    f.setVisible(true);
  }
}
