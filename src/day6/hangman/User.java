package day6.hangman;

public class User {
  private String name;
  private int life = 10;
  private int answerCount = 0;

  public User(String name) {
    this.name = name;
  }

  public void minusLife() {
    life--;
  }

  public String getName() {
    return name;
  }

  public int getLife() {
    return life;
  }

  public void answerCountUp() {
    answerCount++;
  }
}
