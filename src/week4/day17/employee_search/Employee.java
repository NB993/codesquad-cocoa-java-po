package week4.day17.employee_search;

public class Employee {

  String employeeId;
  String name;
  String departmentCode;

  public Employee(String employeeId, String name, String departmentCode) {
    this.employeeId = employeeId;
    this.name = name;
    this.departmentCode = departmentCode;
  }

  public String getEmployeeId() {
    return employeeId;
  }

  public String getName() {
    return name;
  }

  public String getDepartmentCode() {
    return departmentCode;
  }

}
