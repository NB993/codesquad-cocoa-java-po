package week4.day17.employee_search;

import java.awt.*;

public class EmployeeSearch {
  EmployeeSearchFrame frame;
  SearchPanel searchPanel;
  ResultPanel resultPanel;

  public static void main(String[] args) {
    Frame frame = new EmployeeSearchFrame().getFrame();
    frame.add(new SearchPanel().getPanel());
    frame.add(new ResultPanel().getPanel());

    frame.setVisible(true);
  }

}
