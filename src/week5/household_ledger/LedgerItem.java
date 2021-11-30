package week5.household_ledger;

import java.time.LocalDate;

public class LedgerItem {
  private LocalDate date;
  private String brief;
  private int income;
  private int expenses;
  private String type;

  public LocalDate getDate() {
    return date;
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

  public String getType() {
    return type;
  }
}
