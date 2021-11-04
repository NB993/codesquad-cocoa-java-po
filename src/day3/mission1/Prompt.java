package day3.mission1;

import java.nio.charset.Charset;
import java.util.*;
import java.io.*;

public class Prompt {

  public static final String YEAR = "연도";
  public static final String MONTH = "월";
  public static final String DAY = "일";
  public static final String FILE_NAME_YEAR = "year";
  public static final String FILE_NAME_MONTH = "month";
  public static final String FILE_NAME_DAY = "day";
  public static final int INPUT_MIN_YEAR = 0;
  public static final int INPUT_MAX_YEAR = 9999;
  public static final int INPUT_MIN_MONTH = 1;
  public static final int INPUT_MAX_MONTH = 12;
  public static final int INPUT_MIN_DAY = 1;
  public static final int INPUT_MAX_DAY = 31;


  public static Scanner sc = new Scanner(System.in);

  public List<String> input() {
    System.out.println("생년월일을 입력하시면 인디언식 이름을 지어드립니다.");
    List<String> birthDates = inputDate();

    sc.close();

    //첫 inputDate호출 시 잘못된 date가 입력되어 inputDate가 재 호출될 시
    //여기서 birthDates의 size가 0이 된 채로 넘어감.
    System.out.println(birthDates.size());

    List<String> names = createName(birthDates);

    return names;
  }

  private List<String> inputDate() {
    List<String> birthDates = new ArrayList<>();

    try {
      validateDate(YEAR, INPUT_MIN_YEAR, INPUT_MAX_YEAR, birthDates);
      validateDate(MONTH, INPUT_MIN_MONTH, INPUT_MAX_MONTH, birthDates);
      validateDate(DAY, INPUT_MIN_DAY, INPUT_MAX_DAY, birthDates);
    } catch (IllegalArgumentException e) {
      inputDate();
    } catch (Exception e) {
      System.out.println("잘못 입력되었습니다. 다시 입력해주세요.");
      inputDate();
    }

    return birthDates;
  }

  private void validateDate(String currentInput, int min, int max,
      List<String> birthDates) {

    System.out.print(currentInput + " : ");

    //숫자가 아니라 글자가 입력돼서 다시 inputDate가 호출될 때 스캐너가 다시 입력을 안받음..
    //그래서 IllegalArgumentException 에러를 반복해서 던짐
    int inputValue = sc.nextInt();

    if (inputValue < min || inputValue > max) {
      System.out.println(currentInput + "은(는) "
          + min + "이상 " + max + "이하의 값을 입력해주세요");

      throw new IllegalArgumentException();
    }

    birthDates.add(Integer.toString(inputValue));
  }

  private List<String> createName(List<String> birthDates) {
    Map<String, String> firstNames = new HashMap<>();
    Map<String, String> middleNames = new HashMap<>();
    Map<String, String> lastNames = new HashMap<>();

    try {
      firstNames = readIndianNamingFile(FILE_NAME_YEAR);
      middleNames = readIndianNamingFile(FILE_NAME_MONTH);
      lastNames = readIndianNamingFile(FILE_NAME_DAY);
    } catch (IOException e) {
      System.out.println("네이밍 규칙을 불러오는 데 실패하였습니다.");
    }

    List<String> names = matchDateWithName(birthDates, firstNames, middleNames, lastNames);

    return names;
  }

  private List<String> matchDateWithName(List<String> birthDates,
      Map firstNames, Map middleNames, Map lastNames) {

    List<String> names = new ArrayList<>();

    String birthYear = birthDates.get(0);
    String birthMonth = birthDates.get(1);
    String birthDay = birthDates.get(2);

    names.add((String) firstNames.get(birthYear.substring(birthYear.length() - 1)));
    names.add((String) middleNames.get(birthMonth));
    names.add((String) lastNames.get(birthDay));

    return names;
  }

  private Map<String, String> readIndianNamingFile(String fileName) throws IOException {
    String path = Prompt.class.getResource("").getPath();

    FileReader fr = new FileReader(path + "static/indian-naming/" + fileName + ".txt",
        Charset.forName("UTF-8"));
    BufferedReader br = new BufferedReader(fr);

    Map names = new HashMap<String, String>();
    String singleLine = "";

    while ((singleLine = br.readLine()) != null) {
      String[] splitLine = singleLine.split(":");

      try {
        names.put(splitLine[0], splitLine[1]);
      } catch (ArrayIndexOutOfBoundsException e) {
        names.put(splitLine[0], ""); //4, 5, 6일
      }

    }

    br.close();

    return names;
  }

  public void print(Indian indian) {
    System.out.println(indian);
  }

}
