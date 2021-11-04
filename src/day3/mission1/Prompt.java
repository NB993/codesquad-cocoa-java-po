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
    List<Integer> birthDates = new ArrayList<Integer>();

    try {
      System.out.println("생년월일을 입력해주세요" );
      birthDates = validateInput();
    } catch (IllegalArgumentException e) {
      input();
    } catch (Exception e) {
      System.out.println("잘못 입력되었습니다. 다시 입력해주세요." );
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

  private List<Integer> validateInput() {
    List<Integer> birthDates = new ArrayList<Integer>();

    validateYear(birthDates);
    validateMonth(birthDates);
    validateDay(birthDates);

    return birthDates;
  }

  private List<Integer> validateYear(List<Integer> birthDates) {
    printGuideForInput(YEAR);
    int year = sc.nextInt();

    if (year < INPUT_MIN_YEAR || year > INPUT_MAX_YEAR) {
      printGuideForError(YEAR);

      throw new IllegalArgumentException();
    }

    birthDates.add(year);

    return birthDates;
  }


  private List<Integer> validateMonth(List<Integer> birthDates) {
    printGuideForInput(MONTH);
    int month = sc.nextInt();

    if (month < INPUT_MIN_MONTH || month > INPUT_MAX_MONTH) {
      printGuideForError(MONTH);

      throw new IllegalArgumentException();
    }

    birthDates.add(month);

    return birthDates;
  }

  private List<Integer> validateDay(List<Integer> birthDates) {
    printGuideForInput(DAY);
    int day = sc.nextInt();

    if (day < INPUT_MIN_DAY || day > INPUT_MAX_DAY) {
      printGuideForError(DAY);

      throw new IllegalArgumentException();
    }

    birthDates.add(day);

    return birthDates;
  }

  private void printGuideForError(String currentInput) {
    System.out.print("올바르지 않은 값을 입력하셨습니다. " );

    //이거 어떻게 하나로 합칠 수 있을까..
    if (currentInput == YEAR) {
      System.out.println(YEAR + "은(는) "
          + INPUT_MIN_YEAR + "이상 " + INPUT_MAX_YEAR + "이하의 값을 입력해주세요" );
    }

    if (currentInput == MONTH) {
      System.out.println(MONTH + "은(는) "
          + INPUT_MIN_MONTH + "이상 " + INPUT_MAX_MONTH + "이하의 값을 입력해주세요" );
    }

    if (currentInput == DAY) {
      System.out.println(DAY + "은(는) "
          + INPUT_MIN_DAY + "이상 " + INPUT_MAX_DAY + "이하의 값을 입력해주세요" );
    }
  }


  private void printGuideForInput(String currentInput) {
    System.out.print(currentInput + " : " );
  }

  private List<String> createName(List<Integer> birthDates) throws IOException {
    List<String> names = new ArrayList<>();

    //여기서 파일 읽고 birthDate항목과 연월일 비교해서 이름 리스트 만들어준 후 리턴

    //파일읽어오는 메서드
    Map firstNames = readIndianNamingFile(FILE_NAME_YEAR);
    Map middleNames = readIndianNamingFile(FILE_NAME_MONTH);
    Map lastNames = readIndianNamingFile(FILE_NAME_DAY);

    //비교하는 메서드 분리
    names = matchDateWithName(birthDates, firstNames, middleNames, lastNames);

    return names;
  }

  private List<String> matchDateWithName(List<Integer> birthDates,
      Map firstNames, Map middleNames, Map lastNames) {

    List<String> names = new ArrayList<>();
    int birthYear = birthDates.get(0);
    int birthMonth = birthDates.get(1);
    int birthDay = birthDates.get(2);

    //형변환이 필요했다..
    names.add((String) firstNames.get(birthYear));
    names.add((String) middleNames.get(birthMonth));
    names.add((String) lastNames.get(birthDay));

    return names;
  }

  private Map<String, String> readIndianNamingFile(String fileName) throws IOException {
    String path = Prompt.class.getResource("" ).getPath();

    FileReader fr = new FileReader(path + "static/indian-naming/" + fileName + ".txt",
        Charset.forName("UTF-8" ));
    BufferedReader br = new BufferedReader(fr);

    Map names = new HashMap<String, String>();
    String singleLine = "";

    while ((singleLine = br.readLine()) != null) {
      String[] splitLine = singleLine.split(":" );
      names.put(splitLine[0], splitLine[1]);
    }

    br.close();

    return names;
  }

  public void print(Indian indian) {
    System.out.println(indian);
  }

}
