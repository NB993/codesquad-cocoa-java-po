package day6.householdledger;

public class LedgerItem {
  private final int order;
  private String brief;
  private double income;
  private double outcome;
  private double balance;

  public LedgerItem(int order, String brief, double income, double outcome, double balance) {
    this.order = order;
    this.brief = brief;
    this.income = income;
    this.outcome = outcome;
    this.balance = balance;
  }
}
