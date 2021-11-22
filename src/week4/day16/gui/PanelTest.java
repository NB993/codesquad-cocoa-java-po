package week4.day16.gui;

import java.awt.*;

public class PanelTest {

  public static void main(String[] args) {
    Frame f = new Frame();
    int frameWidth = 300;
    int frameHeight = 200;

    f.setSize(frameWidth, frameHeight);
    f.setLayout(null);

    Panel p = new Panel();
    p.setBackground(Color.CYAN);
    p.setSize(200, 150);
    p.setLocation(50, 40);

    Button ok = new Button("OK");
    p.add(ok);
    f.add(p);
    f.setVisible(true);
  }
}
