package day3.mission1;

import java.util.*;

public class Prompt {
  public static final String YEAR = "연도";
  public static final String MONTH = "월";
  public static final String DAY = "일";
  public static final int INPUT_MIN_YEAR = 0;
  public static final int INPUT_MIN_MONTH = 1;
  public static final int INPUT_MAX_MONTH = 12;
  public static final int INPUT_MIN_DAY = 1;
  public static final int INPUT_MAX_DAY = 31;


  public static Scanner sc = new Scanner(System.in);

  public List<String> input() {
    List<Integer> birthDates = new ArrayList<Integer>();

    try {
      System.out.println("생년월일을 입력해주세요");
      birthDates = validateInput();
    } catch (IllegalArgumentException e) {
      input();
    } catch(Exception e) {
      System.out.println("잘못 입력되었습니다. 다시 입력해주세요.");
      input();
    }

    sc.close();

    List<String> names = createName(birthDates);

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

    if (year < INPUT_MIN_YEAR) {
      printGuideForError(YEAR);
    }

    birthDates.add(year);

    return birthDates;
  }


  private List<Integer> validateMonth(List<Integer> birthDates) {
    printGuideForInput(MONTH);
    int month = sc.nextInt();

    if (month < INPUT_MIN_MONTH || month > INPUT_MAX_MONTH) {
      printGuideForError(MONTH);
    }

    birthDates.add(month);

    return birthDates;
  }

  private void printGuideForError(String currentInput) {
    if (currentInput == YEAR) {
      System.out.println("올바르지 않은 값을 입력하셨습니다. " + YEAR + "은(는) "
          + INPUT_MIN_YEAR + "이상의 값을 입력해주세요.");

      throw new IllegalArgumentException();
    }

    if (currentInput == MONTH) {
      System.out.println("올바르지 않은 값을 입력하셨습니다. " + MONTH + "은(는) "
          + INPUT_MIN_MONTH + "이상 " + INPUT_MAX_MONTH + "이하의 값을 입력해주세요");

      throw new IllegalArgumentException();
    }

    if (currentInput == DAY) {
      System.out.println("올바르지 않은 값을 입력하셨습니다. " + DAY + "은(는) "
          + INPUT_MIN_DAY + "이상 " + INPUT_MAX_DAY + "이하의 값을 입력해주세요");

      throw new IllegalArgumentException();
    }
  }

  private List<Integer> validateDay(List<Integer> birthDates) {
    printGuideForInput(DAY);
    int day = sc.nextInt();

    if (day < INPUT_MIN_DAY || day > INPUT_MAX_DAY) {
      printGuideForError(DAY);
    }

    birthDates.add(day);

    return birthDates;
  }

  private void printGuideForInput(String currentInput) {
      System.out.print(currentInput + " : ");
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
