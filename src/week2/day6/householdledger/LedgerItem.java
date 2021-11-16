package day6.householdledger;

import java.time.LocalDate;

public class LedgerItem implements Comparable<LedgerItem> {
//  private final int order;
  private LocalDate date;
  private String brief;
  private int income;
  private int expenses;

//  public int getOrder() {
//    return order;
//  }

  public String getBrief() {
    return brief;
  }

  public int getIncome() {
    return income;
  }

  public int getExpenses() {
    return expenses;
  }

  public LocalDate getDate() {
    return date;
  }

  public LedgerItem(/*int order,*/ LocalDate date, String brief, int income, int outcome) {
//    this.order = order;
    this.date = date;
    this.brief = brief;
    this.income = income;
    this.expenses = expenses;
  }


  @Override
  public int compareTo(LedgerItem o) {
    return this.date.compareTo(o.date);
  }
}


