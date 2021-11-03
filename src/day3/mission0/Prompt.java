package day3.mission0;

import java.util.*;

public class Prompt {

  private static final String[] members = new String[]{"피오", "donggi", "땃쥐", "Tany", "후", "K",
      "노리", "taksu", "Jerry", "MK", "mandoo"};

  private static final Scanner sc = new Scanner(System.in);

  public static int inputHeadCount() {
    int headCount = 0;

    try {
      headCount = sc.nextInt();
    } catch (NumberFormatException e) {
      inputHeadCount();
    }

    try {
      inputValidation(headCount);
    } catch (final Exception e) {
      return inputHeadCount();
    }

    return headCount;
  }



  private static void inputValidation(int input) {
    validateHeadCount(input);
//    프로그램 종료(어떻게 if없이 inputValidation메서드까지 종료시킬 수 있을까?)
//    validateQuitSign(input);
  }

//  private static void validateQuitSign(String input) {
//    if (input.toUpperCase() == "Q") {
//      System.out.println("프로그램을 종료합니다");
//
//      return;
//    }
//  }

  private static void validateHeadCount(int headCount) {
    if (headCount <= 0) {
      System.out.println("1 이상의 값을 입력해 주세요.");

      throw new IllegalArgumentException();
    }

    if (headCount > members.length) {
      System.out.println("현재 총 인원 수는" + members.length + "명입니다.");
    }
  }

  public static void print(ArrayList<String> memberList) {
    for (int i = 0; i < memberList.size(); i++) {
      System.out.println(memberList.get(i));
    }
  }

}
