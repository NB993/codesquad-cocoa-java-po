package day3.mission0;

public class PrintRandomPeople {

  public static void main(String[] args) {
    int headCount = Prompt.inputHeadCount();
    String[] membersList = MemberList.of(headCount);

    Prompt.print(membersList);
  }

}
