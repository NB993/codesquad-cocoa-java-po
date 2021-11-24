package week4.day18.paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import week4.day17.employee_search.AdapterWindowListener;

public class PaintFrame extends Frame {

  static final int DEFAULT_FRAME_WIDTH = 960;
  static final int DEFAULT_FRAME_HEIGHT = 540;

  ToolBoxPanel toolBoxPanel;
  PaintPanel paintPanel;

  public PaintFrame() {
    initFrame();
    this.toolBoxPanel = new ToolBoxPanel();
    this.paintPanel = new PaintPanel();
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
  }
}
