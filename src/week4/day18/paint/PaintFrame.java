package week4.day18.paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import week4.day17.employee_search.AdapterWindowListener;

public class PaintFrame extends Frame {

  private static final int DEFAULT_FRAME_WIDTH = 1024;
  private static final int DEFAULT_FRAME_HEIGHT = 600;

  private Graphics graphics;
  private Graphics2D graphics2D;
  private int startX;
  private int startY;
  private ToolBoxPanel toolBoxPanel;
  private PaintPanel paintPanel;

  public PaintFrame() {
    this.startX = 0;
    this.startY = 0;
    this.toolBoxPanel = new ToolBoxPanel();
    this.paintPanel = new PaintPanel();
    initFrame();
    this.graphics = getGraphics(); //Frame이 렌더링되기 전에 호출하면 null을 리턴함.
    this.graphics2D = (Graphics2D) graphics;

  }


  private void initFrame() {
    initFrame(DEFAULT_FRAME_WIDTH, DEFAULT_FRAME_HEIGHT);
  }

  private void initFrame(int width, int height) {
    setLayout(null);
    setBackground(Color.WHITE);
    setSize(width, height);

    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    setLocation((screenSize.width / 2) - (width / 2), (screenSize.height / 2) - (height / 2));
    addWindowListener(new AdapterWindowListener() {
      @Override
      public void windowClosing(WindowEvent e) {
        e.getWindow().dispose();
      }
    });

    this.add(toolBoxPanel);
    this.add(paintPanel);
    setVisible(true);
  }

  public Graphics getPaintFrameGraphics() {
    return graphics;
  }

  public void setX(int x) {
    startX = x;
  }
  public void setY(int y) {
    startY = y;
  }

  public int getX() {
    return startX;
  }

  public int getY() {
    return startY;
  }

  public Graphics2D getPaintFrameGraphics2D() {
    return graphics2D;
  }
}
