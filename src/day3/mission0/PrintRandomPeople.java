package day3.mission0;

import java.util.*;

public class PrintRandomPeople {

  public static void main(String[] args) {
    int headCount = Prompt.inputHeadCount();
    ArrayList<String> memberList = MemberList.of(headCount);

    Prompt.print(memberList);
  }

}
