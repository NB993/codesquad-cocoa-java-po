package week4.day18.paint;

import java.awt.Graphics;
import java.awt.Panel;

public class PaintPanel extends Panel {

  Graphics graphics;

  public PaintPanel() {
    this.graphics = getGraphics();
    setLayout(null);
  }


}
