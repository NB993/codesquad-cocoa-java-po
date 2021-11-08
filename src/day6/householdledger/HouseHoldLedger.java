package day6.householdledger;

import java.util.*;

public class HouseHoldLedger {
  Map<User, List<LedgerItem>> users = new HashMap<>();
  private String currentUser;
  private List<LedgerItem> itemsOfCurrUser;

  public boolean checkHasUser(String userName) {
    Iterator iterator = users.keySet().iterator();

    while (iterator.hasNext()) {
      User user = (User) iterator.next();

      if(user.getName().equals(userName)) {
        return true;
      }
    }

    return false;
  }

  public boolean registerUser(String userName, String password) {
    User newUser = new User(userName, password);
    List<LedgerItem> ledgerItems = new ArrayList<>();

    users.put(newUser, ledgerItems);

    return true;
  }

  public void signIn(String userName, String password) {
    if (isPasswordCorrect(userName, password)) {
      currentUser = userName;

    }
  }

  private boolean isPasswordCorrect(String userName, String password) {
    Iterator iterator = users.keySet().iterator();

    while (iterator.hasNext()) {
      User user = (User) iterator.next();

      if (user.getName().equals(userName)) {
        return user.getPassword().equals(password);
      }
    }

    return false;
  }

  public void doTask(int taskNum) {


  }


  private void loadLedgerItems(String currentUser) {
    Iterator iterator = users.iterator();

    while (iterator.hasNext()) {
      Map<User, List<LedgerItem>> user = (Map<User, List<LedgerItem>>) iterator.next();

      if (user.containsKey(currentUser)) {
        itemsOfCurrUser = user.get(currentUser);
      }
    }
  }

  public void edit(int order, LedgerItem item) {

  }
}
