package day6.hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

public class Game {
  private ProblemStore problemStore;
  private User user;
  private Scanner sc = new Scanner(System.in);
  private Print print = new Print();
  private HangMan hangMan = new HangMan();

  public void init() {
    user = new User("p.o");
    problemStore = new ProblemStore();
    List<Problem> problems = loadProblems("hangman-words");
    problemStore.getProblems().addAll((List) problems);
  }

  public void start() {
    Problem problem = problemStore.getRandomProblem();
    String answer = problem.getAnswer();
    int neededAnswerCount = getNeededAnswerCount(answer);
    int currentAnswerCount = 0;

    print.printBlankOfAnswerLength(answer);
    String alphabet;
    int userLife;

    //TODO: 임시로 정답 표시. 나중에 지우기
    System.out.println("정답은:" + answer);
    
    while (user.getLife() != 0) {
      alphabet = sc.next();

      if (!answer.contains(alphabet)) {
        System.out.println("틀렸습니다. 라이프를 차감합니다.");
        user.minusLife();
        userLife = user.getLife();
        hangMan.stackUpHangMan(userLife);
        print.printUserLife(userLife);
        print.printHangman(hangMan);

        continue; //continue 말고 다른 방법은 없을까?
      }

      System.out.println("정답!");

    }

    if (checkDoNextGame()) {
      start();
      return;
    };

    System.out.println("프로그램 종료");

  }

  private int getNeededAnswerCount(String answer) {
    String[] alphabetArr = answer.split("");
    List<String> alphabetList = new ArrayList<>(Arrays.asList(alphabetArr));
    Set<String> alphabetSet = new HashSet<>(alphabetList);
    return alphabetSet.size();
  }

  private boolean checkDoNextGame() {
    System.out.println("게임 종료. 다시 하시겠습니까?(y/Y) 그만하시려면 아무키나 입력해주세요.");
    return sc.nextLine() == "Y" ? true : false;
  }

  public void showResult() {

  }

  private List<Problem> loadProblems(String fileName) {
    List<Problem> fileData = new ArrayList<>();

    try {
      String path = this.getClass().getResource("").getPath();
      System.out.println(path);
      FileReader fr = new FileReader(path + "static/" + fileName + ".txt", Charset.forName("UTF-8"));
      BufferedReader br = new BufferedReader(fr);
      String singleLine = "";

      while ((singleLine = br.readLine()) != null) {
        fileData.add(createNewProblem(singleLine));
      }
    } catch (IOException e) {
      System.out.println("문제 파일을 읽어오는 도중 에러가 발생하였습니다.");
    }

    return fileData;
  }

  private Problem createNewProblem(String singleLine) {
    String[] splitLine = singleLine.split(":");
    return new Problem(splitLine[0], splitLine[1]);
  }
}
