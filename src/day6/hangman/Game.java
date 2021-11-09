package day6.hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

public class Game {
  private List<Problem> problems;
  private Scanner sc = new Scanner(System.in);

  public void init() {
    problems = new Problems().getProblems();
    List<Problem> fileData = loadProblems("hangman-words");
    problems.addAll((List) fileData);
  }

  public void start() {
    Problem problem = problems.getㅋㅋ
    String alphabet = sc.next();
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
