package day6.householdledger;

import java.io.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Prompt {

  final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public String inputUserName() {
    String name = null;

    try {
      name = br.readLine();
    } catch (IOException e) {
      //처리 했다 치고
    }

    return name;
  }

  public String inputRegisterSign() {
    String answer = null;

    try {
      answer = br.readLine().toUpperCase();
    } catch (IOException e) {
      answer = "";
    }

    if (!answer.equals("Y") && !answer.equals("N")) {
      System.out.println("Y 또는 N을 입력해주세요.");
      return inputRegisterSign();
    }

    return answer.toUpperCase();
  }

  public LedgerItem inputNewItem(int numbering) {
    String brief = inputBrief();
    int income = inputIncome();
    int expenses = inputExpenses();

    return new LedgerItem(numbering, brief, income, expenses);
  }

  public int inputTaskSelection() {
    System.out.println();
    System.out.println("---- 작업하실 항목의 번호를 입력해주세요 ----------------------------");
    System.out.println(" [1]신규 항목 추가 [2]항목 수정 [3]항목 삭제 [4]로그인 단계로 [5]종료");
    System.out.println("---------------------------------------------------------------");

    int taskNum = 0;

    try {
      taskNum = Integer.parseInt(br.readLine());
    } catch (IOException e) {
      System.out.println("숫자로 입력해주세요.");
      return inputTaskSelection();
    }

    return taskNum;
  }

  public boolean inputIsTaskGoingOn() {
    System.out.println("작업을 계속 하시려면 (y/Y)를, 그만하시려면 아무 키나 입력해주십시오.");
    String isTaskGoingOn = null;

    try {
      isTaskGoingOn = br.readLine().toUpperCase();
    } catch (IOException ignored) {}

    return isTaskGoingOn.equals("Y") ? true : false;
  }

  private String inputBrief() {
    System.out.print("적요를 입력해주세요 : ");
    String brief;

    try {
      brief = br.readLine();
    } catch (IOException e) {
      System.out.println("[!]적요를 정확히 입력해주세요(정확히 어떻게? - readLine 찾아봐야함)");
      return inputBrief();
    }
    return brief;
  }

  private int inputIncome() {
    System.out.print("수입 금액을 입력해주세요 : ");
    return inputAmountOfMoney();
  }

  private int inputExpenses() {
    System.out.print("지출 금액을 입력해주세요 : ");
    return inputAmountOfMoney();
  }

  private int inputAmountOfMoney() {
    int amountOfMoney = 0;

    try {
      amountOfMoney = Integer.parseInt(br.readLine());
    } catch (IOException e) {
      System.out.println("[!]금액을 정확히 입력해주세요");
      return inputAmountOfMoney();
    }

    return amountOfMoney;
  }

  public int inputDeleteOrder() {
    return 0;
  }

  public int inputItemOrder() {
    System.out.println("항목 번호를 입력해주세요.");
    int order = 0;

    try {
      order = Integer.parseInt(br.readLine());
    } catch (IOException e) {
      //했다 치고
    }

    return order;
  }

  public String inputPassword() {
    String password = null;

    try {
      password = br.readLine();
    } catch (IOException e) {
      //했다 치고
    }

    return password;
  }

  public void printCurrentLedger(List<LedgerItem> ledgerItems) {
    LedgerItem item;

//    Collections.sort(ledgerItems);

    Iterator iterator = ledgerItems.iterator();

    while (iterator.hasNext()) {
      item = (LedgerItem) iterator.next();
      System.out.printf("|%-2d| [적요] %-10s   [수입] %10d  [지출] %10d \n", item.getOrder(), item.getBrief(),
        item.getIncome(), item.getExpenses());

    }
  }

}
