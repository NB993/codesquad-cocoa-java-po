package day6.householdledger;

import java.util.ArrayList;
import java.util.List;

public class User {
  String name;
  String password;
  List<LedgerItem> ledgerItems;

  public User(String name, String password) {
    this.name = name;
    this.password = password;
    ledgerItems = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public List<LedgerItem> getLedgerItems() {
    return ledgerItems;
  }

  public String getPassword() {
    return password;
  }
}
