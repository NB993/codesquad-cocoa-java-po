package day3.mission0;

import java.util.*;

public class MemberList {

  private static final String[] MEMBERS = new String[]{"피오", "donggi", "땃쥐", "Tany", "후", "K",
      "노리", "taksu", "Jerry", "MK", "mandoo"};


  public static List<String> of(int headCount) {
    List<String> members = addMember(MEMBERS);
    shuffleMember(members);

    return cutMemberList(members, headCount);
  }

  private static List<String> addMember(String[] MEMBERS) {
//    List<String> members = new ArrayList<>();
//
//    for (int i = 0; i < MEMBERS.length; i++) {
//      members.add(MEMBERS[i]);
//    }

    return Arrays.asList(MEMBERS);

  }

  private static void shuffleMember(List<String> members) {
    Collections.shuffle(members);
  }

  private static List<String> cutMemberList(List<String> members, int headCount) {
    if (MEMBERS.length < headCount) {
      headCount = MEMBERS.length;
    }

    return members.subList(0, headCount);
  }

}
