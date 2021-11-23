package week4.day17.employee_search;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
    panel.setLayout(new GridLayout());
    panel.setBackground(Color.LIGHT_GRAY);
    panel.setSize(700, 150);
    panel.setLocation(50, 230);

  }

  public Panel getPanel() {
    return panel;
  }
}
