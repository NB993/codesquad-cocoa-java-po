package day3.mission1;

import java.util.*;

public class Indian {

  String firstName;
  String middleName;
  String lastName;

  public Indian(List<String> names) {
    this.firstName = names.get(0);
    this.middleName = names.get(1);
    this.lastName = names.get(2);
  }

  @Override
  public String toString() {
    return firstName + " " + middleName + " " + lastName;
  }

}
