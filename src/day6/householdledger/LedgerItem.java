package day6.householdledger;

public class LedgerItem implements Comparable<LedgerItem> {
  private final int order;
  private String brief;
  private int income;
  private int expenses;

  public int getOrder() {
    return order;
  }

  public String getBrief() {
    return brief;
  }

  public int getIncome() {
    return income;
  }

  public int getExpenses() {
    return expenses;
  }


  public LedgerItem(int order, String brief, int income, int outcome) {
    this.order = order;
    this.brief = brief;
    this.income = income;
    this.expenses = expenses;
  }

  @Override
  public int compareTo(LedgerItem o) {
    return this.order - o.order;
  }
}
