package day6.hangman;

public class User {
  private String name;
  private int life = 10;

  public User(String name) {
    this.name = name;
  }

  public void minusLife() {
    life--;
  }

}
