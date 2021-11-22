package week4.day16.gui;

import java.awt.*;
import javax.swing.JFrame;

public class Main {

  public static void main(String[] args) {
    Frame f = new Frame();
    int frameWidth = 300;
    int frameHeight = 200;
    f.setSize(frameWidth, frameHeight);

    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    f.setLocation((screenSize.width / 2) - (frameWidth / 2), (screenSize.height / 2) - (frameHeight / 2));

    f.setLayout(null); // 기본 레이아웃 매니저의 설정을 해제하여 컨테이너 내부의 컴포넌트들의 크기와 위치를 내가 직접 관리함.

    Button b = new Button("확인");
    b.setSize(100, 50);
    b.setLocation(100,75); //컴포넌트의 위치를 직접 지정

    f.add(b);

    f.setVisible(true);
  }
}
