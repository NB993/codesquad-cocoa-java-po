package day6.householdledger2;

public class User {

  private final String name;
  private final String password;
  private final Ledger ledger;

  public User(String name, String password) {
    this.name = name;
    this.password = password;
    this.ledger = loadMyLedger(name);
  }

  private Ledger loadMyLedger(String name) {
    return LedgerProgram.loadMyLedger(name);
  }

  //작성/편집/삭제를 하는 주체는 유저
  public void addLedgerItem()  {

  }
  public void editLedgerItem() {

  }
  public void deleteLedgerItem() {

  }
}

