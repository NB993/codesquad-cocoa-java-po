package week4.day17.employee_search;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextComponent;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.w3c.dom.Text;

public class SearchPanel extends Panel {
  private final Frame parentFrame;
  private final Panel panel;

  public SearchPanel() {
    this.panel = new Panel();
    this.parentFrame = (Frame) this.panel.getParent();
    initPanel();
  }

  private void initPanel() {
    panel.setLayout(new GridBagLayout());
    panel.setBackground(Color.LIGHT_GRAY);
    panel.setSize(700, 150);
    panel.setLocation(50, 40);

    Label lbEmpId = new Label("사번: ");
    lbEmpId.setLocation(50, 10);
    TextField textEmpId = new TextField(6);
    textEmpId.setLocation(100, 10);

    Label lbName = new Label("이름: ");
    lbName.setLocation(50, 30);
    TextField textName = new TextField(20);
    textName.setLocation(100, 30);

    Label lbDepartmentCode = new Label("부서코드: ");
    lbDepartmentCode.setLocation(50, 50);
    TextField textDepartmentCode = new TextField(20);
    textDepartmentCode.setLocation(100, 50);

    Button btnSearch = new Button("검색");
    btnSearch.setLocation(120, 10);
    btnSearch.addActionListener((e) -> {
      searchEmployee(e);
    });

    panel.add(lbEmpId);
    panel.add(textEmpId);
    panel.add(lbName);
    panel.add(textName);
    panel.add(lbDepartmentCode);
    panel.add(textDepartmentCode);
    panel.add(btnSearch);
  }

  public Panel getPanel() {
    return panel;
  }

  private void searchEmployee(ActionEvent e) {
    List<String> searchValue = getTextFieldsValue(e);
    List<Employee> employees = EmployeeStore.getEmployees();

    Predicate<Employee> checkEmpId = (ele) -> {
      return ele.getEmployeeId() != null && ele.getEmployeeId().equals((String)searchValue.get(0));
    };
    Predicate<Employee> checkName = (ele) -> {
      return ele.getEmployeeId() != null && ele.getName().equals((String)searchValue.get(1));
    };
    Predicate<Employee> checkDepartmentCode = (ele) -> {
      return ele.getDepartmentCode() != null && ele.getDepartmentCode().equals((String)searchValue.get(2));
    };

    Predicate<Employee> singleCheck = checkEmpId.or(checkName.or(checkDepartmentCode));

    List<Employee> searchResults = employees.stream()
        .filter(singleCheck).collect(Collectors.toList());
//    List<Employee> searchResults = employees.stream()
//        .filter(singleCheck).forEach(ele -> {
//          System.out.println(ele.getEmployeeId() + " " + ele.getName() + " " + ele.getDepartmentCode());
//        });
    printSearchResult(searchResults);
  }

  private void printSearchResult(List<Employee> results) {
    Panel resultPanel = (Panel) this.getPanel().getParent().getComponent(1);
    for (Employee e : results) {
      Label label = new Label(e.getEmployeeId() + " " + e.getName() + " " + e.getDepartmentCode());
      label.setLocation(150, 80);
//      label.setLocation();
      resultPanel.add(label);
    }
  }


  private List<String> getTextFieldsValue(ActionEvent e) {
    Button searchBtn = (Button) e.getSource();
    Panel panel = (Panel) searchBtn.getParent();
    Component[] components = panel.getComponents();
    TextField textEmpId = (TextField) components[1];
    TextField textName = (TextField) components[3];
    TextField textDepartmentCode = (TextField) components[5];

    List<String> searchValue = new ArrayList<>();
    searchValue.add(textEmpId.getText());
    searchValue.add(textName.getText());
    searchValue.add(textDepartmentCode.getText());

    return searchValue;
  }

}
