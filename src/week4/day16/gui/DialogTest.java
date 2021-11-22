package week4.day16.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogTest {

  public static void main(String[] args) {
    Frame f = new Frame();
    int frameWidth = 300;
    int frameHeight = 200;
    f.setSize(frameWidth, frameHeight);
    f.setLayout(null);

    Button frameButton = new Button("프레임 버튼");
    frameButton.setSize(80,50);
    frameButton.setLocation(200, 150);

    final Dialog info = new Dialog(f, "Info", true); // 세번째 인자는 dialog를 modal로 생성할 것인지의 여부
    info.setSize(140, 90);
    info.setLocation(50, 50);
    info.setLayout(new FlowLayout());

    Label msg = new Label("this is modal dialog", Label.CENTER);
    Button ok = new Button("OK");

//    ok.addActionListener(new ActionListener() {
//      @Override
//      public void actionPerformed(ActionEvent e) {
//        info.dispose();
//      }
//    });
    ok.addActionListener(e -> info.dispose()); //람다로 작성한 액션이벤트

    info.add(msg);
    info.add(ok);
    f.add(frameButton);
    f.setVisible(true);
    info.setVisible(true);
  }
}
