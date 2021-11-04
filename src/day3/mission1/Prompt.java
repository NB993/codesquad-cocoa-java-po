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
    List<String> birthDates = new ArrayList<>();

    try {
      System.out.println("생년월일을 입력해주세요");
      birthDates = validateInput();
    } catch (IllegalArgumentException e) {
      input();
    } catch (Exception e) {
      System.out.println("잘못 입력되었습니다. 다시 입력해주세요.");
      input();
    }

    sc.close();

    List<String> names = new ArrayList<>();

    try {
      names = createName(birthDates);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return names;
  }

  private List<String> validateInput() {
    List<String> birthDates = new ArrayList<>();

    validateYear(birthDates);
    validateMonth(birthDates);
    validateDay(birthDates);

    return birthDates;
  }

  //이렇게 비슷한 메서드를 상수명이 다르다는 이유로 반복하는 건 너무 별로인 것 같다..
  private List<String> validateYear(List<String> birthDates) {
    printGuideForInput(YEAR);
    int year = sc.nextInt();

    if (year < INPUT_MIN_YEAR || year > INPUT_MAX_YEAR) {
      printGuideForError(YEAR);

      throw new IllegalArgumentException();
    }

    birthDates.add(Integer.toString(year));

    return birthDates;
  }


  private List<String> validateMonth(List<String> birthDates) {
    printGuideForInput(MONTH);
    int month = sc.nextInt();

    if (month < INPUT_MIN_MONTH || month > INPUT_MAX_MONTH) {
      printGuideForError(MONTH);

      throw new IllegalArgumentException();
    }

    birthDates.add(Integer.toString(month));

    return birthDates;
  }

  private List<String> validateDay(List<String> birthDates) {
    printGuideForInput(DAY);
    int day = sc.nextInt();

    if (day < INPUT_MIN_DAY || day > INPUT_MAX_DAY) {
      printGuideForError(DAY);

      throw new IllegalArgumentException();
    }

    birthDates.add(Integer.toString(day));

    return birthDates;
  }

  private void printGuideForError(String currentInput) {
    System.out.print("올바르지 않은 값을 입력하셨습니다. ");

    //어떻게 하나로 합칠 수 있을까..
    if (currentInput == YEAR) {
      System.out.println(YEAR + "은(는) "
          + INPUT_MIN_YEAR + "이상 " + INPUT_MAX_YEAR + "이하의 값을 입력해주세요");
    }

    if (currentInput == MONTH) {
      System.out.println(MONTH + "은(는) "
          + INPUT_MIN_MONTH + "이상 " + INPUT_MAX_MONTH + "이하의 값을 입력해주세요");
    }

    if (currentInput == DAY) {
      System.out.println(DAY + "은(는) "
          + INPUT_MIN_DAY + "이상 " + INPUT_MAX_DAY + "이하의 값을 입력해주세요");
    }
  }


  private void printGuideForInput(String currentInput) {
    System.out.print(currentInput + " : ");
  }

  private List<String> createName(List<String> birthDates) throws IOException {
    List<String> names = new ArrayList<>();

    //파일읽어오는 메서드 분리
    Map firstNames = readIndianNamingFile(FILE_NAME_YEAR);
    Map middleNames = readIndianNamingFile(FILE_NAME_MONTH);
    Map lastNames = readIndianNamingFile(FILE_NAME_DAY);

    //비교하는 메서드 분리
    names = matchDateWithName(birthDates, firstNames, middleNames, lastNames);

    return names;
  }

  private List<String> matchDateWithName(List<String> birthDates,
      Map firstNames, Map middleNames, Map lastNames) {

    List<String> names = new ArrayList<>();

    String birthYear = birthDates.get(0);
    String birthMonth = birthDates.get(1);
    String birthDay = birthDates.get(2);

    //저장할 때부터 마지막 한글자만 저장하고 싶으나 validation 메서드들을 하나로 합치고 싶어서 일단 이렇게..
    names.add((String) firstNames.get(
        birthYear.substring(birthYear.length() - 1))
    );
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
