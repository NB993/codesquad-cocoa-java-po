package day3.mission1;

import java.util.*;

public class Prompt {
  public static Scanner sc = new Scanner(System.in);

  public List<String> input() {
    List<Integer> birthDates = new ArrayList<Integer>();
    List<String> names = createName(birthDates);

    return names;
  }

  private List<String> createName(List<Integer> birthDates) {
    List<String> names = new ArrayList<>();

    //여기서 파일 읽고 birthDate항목과 연월일 비교해서 이름 리스트 만들어준 후 리턴
    //파일읽어오는 메서드 분리
    //비교하는 메서드 분리

    return names;
  }

  public void print(Indian indian) {
    System.out.println(indian);
  }

}
