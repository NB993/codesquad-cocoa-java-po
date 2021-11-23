package week4.day17;

import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public class ResultPanel extends Panel {

  private final Panel panel;

  public ResultPanel() {
    this.panel = new Panel();
    initPanel();
  }

  private void initPanel() {
    panel.setBackground(Color.LIGHT_GRAY);
    panel.setSize(300, 200);
    panel.setLocation(400, 40);

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
  }

  public Panel getPanel() {
    return panel;
  }
}
