package week4.day17;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import org.w3c.dom.Text;

public class FrameWithComponents {

  static final int DEFAULT_FRAME_WIDTH = 960;
  static final int DEFAULT_FRAME_HEIGHT = 540;

  SearchPanel searchPanel;
  ResultPanel resultPanel;

  public static void main(String[] args) {
    Frame frame = makeFrame();
    frame.addWindowListener(new AdapterWindowListener() {
      @Override
      public void windowClosing(WindowEvent e) {
        e.getWindow().dispose();
      }
    });

    Panel panel = new Panel();
    panel.setBackground(Color.LIGHT_GRAY);
    panel.setSize(300, 200);
    panel.setLocation(50, 40);

    Label lbName = new Label("사번: ");
    TextField textName = new TextField(20);
    textName.setSize(100, 20);

    Button btnSearch = new Button("검색");
    btnSearch.addActionListener((e) -> {
      System.out.println(textName.getText());
    });

    panel.add(lbName);
    panel.add(textName);
    panel.add(btnSearch);

    frame.add(panel);
    frame.setVisible(true);
  }

  private static Frame makeFrame() {
    return makeFrame(DEFAULT_FRAME_WIDTH, DEFAULT_FRAME_HEIGHT);
  }

  private static Frame makeFrame(int width, int height) {
    Frame frame = new Frame();
    frame.setLayout(null);
    frame.setSize(width, height);

    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    frame.setLocation((screenSize.width / 2) - (width / 2), (screenSize.height / 2) - (height / 2));

    return frame;
  }
}
