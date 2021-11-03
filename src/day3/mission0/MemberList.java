package day3.mission0;

import java.util.Arrays;
import java.util.Random;

public class MemberList {

  private static final String[] members = new String[]{"피오", "donggi", "땃쥐", "Tany", "후", "K",
      "노리", "taksu", "Jerry", "MK", "mandoo"};

  public static String[] of(int headCount) {
    int[] randomNumbers = getRandomNumbers(headCount);
    String[] selectedMembers = selectMembers(randomNumbers);

    return selectedMembers;
  }

  private static int getRandomNumber() {
    return new Random().nextInt(members.length);
  }

  private static int[] getRandomNumbers(int headCount) {
    int[] randomNumbers = new int[headCount];

    for (int i = 0; i < headCount; i++) {
      randomNumbers[i] = getRandomNumber();
    }

//    removeDuplicatedNum(randomNumbers, headCount);

    return randomNumbers;
  }
  private static String[] selectMembers(int[] randomIndices) {
    String[] randomMembers = new String[randomIndices.length];

    for (int i=0; i < randomIndices.length; i++) {
      randomMembers[i] = members[randomIndices[i]];
    }

    return randomMembers;
  }

//  private static int[] removeDuplicatedNum(int[] randomNumbers, int headCount) {
//  }
}
