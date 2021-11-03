package day3.mission0;

import java.util.*;

public class MemberList {

  private static final String[] MEMBERS = new String[]{"피오", "donggi", "땃쥐", "Tany", "후", "K",
      "노리", "taksu", "Jerry", "MK", "mandoo"};


  public static List<String> of(int headCount) {
    List<String> memberList = addMember(MEMBERS);
    shuffleMember(memberList);

    return cutMemberList(memberList, headCount);
  }

  private static List<String> addMember(String[] MEMBERS) {
    List<String> memberList = new ArrayList<>();

    for (int i = 0; i < MEMBERS.length; i++) {
      memberList.add(MEMBERS[i]);
    }

    return memberList;

  }

  private static void shuffleMember(List<String> memberList) {
    Collections.shuffle(memberList);
  }

  private static List<String> cutMemberList(List<String> memberList, int headCount) {
    if (MEMBERS.length < headCount) {
      headCount = MEMBERS.length;
    }

    return memberList.subList(0, headCount);
  }

}
