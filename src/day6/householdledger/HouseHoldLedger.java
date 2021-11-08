package day6.householdledger;

import java.util.*;

public class HouseHoldLedger {
  List<Map<User, List<LedgerItem>>> users = new ArrayList<>();
  private String currentUser;


  public boolean checkHasUser(String userName) {
    Iterator iterator = users.iterator();

    while (iterator.hasNext()) {
      Map<User, List<LedgerItem>> users = (Map<User, List<LedgerItem>>) iterator.next();

      if(users.containsKey(userName)) {
        return true;
      }
    }

    return false;
  }

  public boolean registerUser(String userName) {
    if (checkHasUser(userName)) {
      return false;
    };

    return true;
  }

  public void signIn(String userName) {

    currentUser = userName;
  }

  public void doTask(int taskNum) {
    printCurrentLedger();
    List<LedgerItem> ledgerItems = loadLedgerItems(currentUser);

    if (taskNum == 1) {
    }
    if (taskNum == 2) {

    }
    if (taskNum == 3) {

    }

  }

  private void printCurrentLedger() {
    List<LedgerItem> ledgerItems = loadLedgerItems(currentUser);

  }

  private List<LedgerItem> loadLedgerItems(String currentUser) {
    Iterator iterator = users.iterator();
    List<LedgerItem> ledgerItems = new ArrayList<>();

    while (iterator.hasNext()) {
      Map<User, List<LedgerItem>> user = (Map<User, List<LedgerItem>>) iterator.next();

      if (user.containsKey(currentUser)) {
        ledgerItems = user.get(currentUser);
      }
    }

    return ledgerItems;
  }

}
