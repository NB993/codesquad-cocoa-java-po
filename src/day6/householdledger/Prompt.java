package day6.householdledger;

import java.io.*;

public class Prompt {

  final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public String inputUserName() {
    String name = null;

    try {
      name = br.readLine();
      System.out.println("이름:" + name);
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

  public String inputNewItem() {
    String newItem = null;

    try {
      newItem = br.readLine();
    } catch (IOException e) {
      //처리 했다 치고
    }

    return newItem;
  }

  public int inputTaskSelection() {
    System.out.println("---- 작업하실 항목의 번호를 입력해주세요 -----");
    System.out.println("[1]신규 항목 추가 [2]항목 수정 [3]항목 삭제 ");
    System.out.println("----------------------------------------");

    int taskNum = 0;

    try {
      taskNum = Integer.parseInt(br.readLine());
      //이 부분에서 유효성 검사돌려서 1~3 이외의 값은 throws 에러 던져서 재입력 받기.
    } catch (IOException e) {
      //처리 했다 치고
    }

    return taskNum;
  }

  public boolean inputIsTaskGoingOn() {
    System.out.println("가계부 작성을 계속하시려면 y/Y를, 그만하시려면 아무 키나 입력해주십시오.");

    String isTaskGoingOn = null;

    try {
      isTaskGoingOn = br.readLine();
    } catch (IOException e) {

    }
    return isTaskGoingOn.equals("Y") ? true : false;
  }
}
