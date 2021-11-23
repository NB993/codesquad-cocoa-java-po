package week4.day17.employee_search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import week2.day6.hangman.Problem;

public class EmployeeStore {

  private final List<Employee> employees;

  public EmployeeStore() {
    this.employees = new ArrayList<>();
    loadEmployeesFile();
  }

  private void loadEmployeesFile() {
    try {
      String path = this.getClass().getResource("").getPath();
      System.out.println(path);
      FileReader fr = new FileReader(path + "/employees.txt", Charset.forName("UTF-8"));
      BufferedReader br = new BufferedReader(fr);
      String singleLine = "";
      String[] employeeData;

      while ((singleLine = br.readLine()) != null) {
        addSingleEmployee(singleLine.split(" "));
      }
    } catch (IOException e) {
      System.out.println("문제 파일을 읽어오는 도중 에러가 발생하였습니다.");
    }
  }

  private void addSingleEmployee(String[] employeeData) {
    employees.add(new Employee(employeeData[0], employeeData[1], employeeData[2]));
  }

}
