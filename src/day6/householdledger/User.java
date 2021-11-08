package day6.householdledger;

import java.util.ArrayList;
import java.util.List;

public class User {
  String name;
  String password;
  List<LedgerItem> ledgerList;

  public User(String name, String password) {
    this.name = name;
    this.password = password;
    ledgerList = new ArrayList<>();
  }
}
