package week4.day17.employee_search;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

public class EmployeeSearchFrame {
  static final int DEFAULT_FRAME_WIDTH = 960;
  static final int DEFAULT_FRAME_HEIGHT = 540;

  private final Frame frame;

  public EmployeeSearchFrame() {
    this(DEFAULT_FRAME_WIDTH, DEFAULT_FRAME_HEIGHT);
  }

  public EmployeeSearchFrame(int width, int height) {
    this.frame = new Frame();
    initFrame(width, height);
  }

  private void initFrame(int width, int height) {
    frame.setLayout(null);
    frame.setSize(width, height);

    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    frame.setLocation((screenSize.width / 2) - (width / 2), (screenSize.height / 2) - (height / 2));
    frame.addWindowListener(new AdapterWindowListener() {
      @Override
      public void windowClosing(WindowEvent e) {
        e.getWindow().dispose();
      }
    });
  }

  public Frame getFrame() {
    return frame;
  }
}
