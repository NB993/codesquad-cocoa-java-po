package day6.householdledger;

import java.util.*;

public class Ledger {

  private final Map<String, User> users = new HashMap<>();
  private User currentUser;
  private List<LedgerItem> itemsOfCurrUser = new ArrayList<>();

  public boolean checkHasUser(String userName) {
    Iterator iterator = users.keySet().iterator();

    while (iterator.hasNext()) {
      User user = (User) users.get(iterator.next());

      if (user.getName().equals(userName)) {
        return true;
      }
    }

    return false;
  }

  public boolean registerUser(String userName, String password) {
    User newUser = new User(userName, password);
    users.put(userName, newUser);

    return true;
  }

  public boolean signIn(String userName, String password) {
    if (isPasswordCorrect(userName, password)) {
      return true;
    }
    return false;
  }

  private boolean isPasswordCorrect(String userName, String password) {
    Iterator iterator = users.keySet().iterator();

    while (iterator.hasNext()) {
      String nameKey = (String) iterator.next();
      User user = (User) users.get(nameKey);

      if (user.getName().equals(userName)) {
        currentUser = user;
        return user.getPassword().equals(password);
      }
    }

    return false;
  }

  public void doTask(int taskNum) {

  }


  private void loadLedgerItems(String currentUser) {
    Iterator iterator = users.keySet().iterator();

    while (iterator.hasNext()) {//users Map의 iterator
      User user = (User) users.get(iterator.next());

      if (user.getName().equals(currentUser)) {
        itemsOfCurrUser = user.getLedgerItems();
        System.out.println(itemsOfCurrUser);
      }
    }

  }

  public void edit(int order, LedgerItem item) {

  }

  public void changeUser() {
  }

  public User getCurrentUser() {
    return currentUser;
  }
}
