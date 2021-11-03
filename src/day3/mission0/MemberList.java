package day3.mission0;

import java.util.*;

public class MemberList {

  private static final String[] memberArr = new String[]{"피오", "donggi", "땃쥐", "Tany", "후", "K",
      "노리", "taksu", "Jerry", "MK", "mandoo"};


  public static ArrayList<String> of(int headCount) {
    ArrayList<String> memberList = addMember(memberArr);
    shuffleMember(memberList);

    return cutMemberList(memberList, headCount);
  }

  private static ArrayList<String> addMember(String[] memberArr) {
    ArrayList<String> memberList = new ArrayList<>();

    for (int i = 0; i < memberArr.length; i++) {
      memberList.add(memberArr[i]);
    }

    return memberList;

  }

  private static void shuffleMember(ArrayList<String> memberList) {
    Collections.shuffle(memberList);
  }

  private static ArrayList<String> cutMemberList(ArrayList<String> memberList, int headCount) {
    if (memberArr.length < headCount) {
      headCount = memberArr.length;
    }

    return new ArrayList<String>(memberList.subList(0, headCount));
  }

}
