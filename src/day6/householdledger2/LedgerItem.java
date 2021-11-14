package day6.householdledger2;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LedgerItem {

  String brief;
  LocalDate date;
  BigDecimal income;
  BigDecimal expenditure;
  String category;

  public LedgerItem(String brief, LocalDate date, BigDecimal income, BigDecimal expenditure,
      String category) {
    this.brief = brief;
    this.date = date;
    this.income = income;
    this.expenditure = expenditure;
    this.category = category;
  }


}
