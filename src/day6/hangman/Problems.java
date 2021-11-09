package day6.hangman;

import java.util.*;

public class Problems {
  private List<Problem> problems = new ArrayList<>();

  public Problem getRandomProblem() {
    int randomIndex = (int) Math.random() * problems.size();
    return problems.get(randomIndex);
  }

  public List<Problem> getProblems() {
    return problems;
  }
}