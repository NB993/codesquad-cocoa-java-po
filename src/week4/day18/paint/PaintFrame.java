package week4.day18.paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import week4.day17.employee_search.AdapterWindowListener;

public class PaintFrame extends Frame {

  static final int DEFAULT_FRAME_WIDTH = 1024;
  static final int DEFAULT_FRAME_HEIGHT = 600;

  Graphics graphics;
  Point drawStart;
  Point drawEnd;
  ToolBoxPanel toolBoxPanel;
  PaintPanel paintPanel;

  public PaintFrame() {
    this.toolBoxPanel = new ToolBoxPanel();
    this.paintPanel = new PaintPanel();
    this.drawStart = new Point();
    this.drawEnd = new Point();
    initFrame();
    this.graphics = getGraphics(); //Frame이 렌더링되기 전에 호출하면 null을 리턴함.
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

    addEventListeners();

    this.add(toolBoxPanel);
    this.add(paintPanel);
    setVisible(true);
  }

  private void addEventListeners() {
    windowClose();
    mousePress();
    mouseReleased();
//    mouseMoving();
//    mouseDragging();
  }

  private void mouseReleased() {
    addMouseListener(new AdapterMouseListener() {
      @Override
      public void mouseReleased(MouseEvent e) {
        graphics.drawLine(
            (int)drawStart.getX(),
            (int)drawStart.getY(),
            (int)drawEnd.getX(),
            (int)drawEnd.getY()
        );
      }
    });
  }

  private void mouseMoving() {
    addMouseMotionListener(new AdapterMouseListener() {
      @Override
      public void mouseMoved(MouseEvent e) {
        drawStart.setLocation(e.getX(), e.getY());
      }
    });
  }

  private void mousePress() {
    addMouseListener(new AdapterMouseListener() {
      @Override
      public void mousePressed(MouseEvent e) {
        drawStart.setLocation(e.getX(), e.getY());
      }
    });
  }

  private void mouseDragging() {
    addMouseMotionListener(new AdapterMouseListener() {
      @Override
      public void mouseDragged(MouseEvent e) {
//        graphics.drawLine((int)drawStart.getX(), (int)drawStart.getY(), e.getX(), e.getY());
        drawEnd.setLocation(e.getX(), e.getY());
      }
    });
  }

  private void windowClose() {
    addWindowListener(new AdapterWindowListener() {
      @Override
      public void windowClosing(WindowEvent e) {
        e.getWindow().dispose();
      }
    });
  }
}
