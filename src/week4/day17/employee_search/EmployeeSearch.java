package week4.day17.employee_search;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeeSearch {

  public static void main(String[] args) {
    EmployeeStore.loadEmployeesFile();
    Frame frame = new EmployeeSearchFrame().getFrame();
    frame.add(new SearchPanel().getPanel());
    frame.add(new ResultPanel().getPanel());

    frame.setVisible(true);
  }

}
