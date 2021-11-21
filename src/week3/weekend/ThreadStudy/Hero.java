package week3.weekend.ThreadStudy;

public class Hero {
  int hp;

  public Hero() {
    this.hp = 100;
  }

  public void attack() {
    hp -= 5;
    System.out.println("공격! 남은 hp: " + hp);
  }

  public void drinkHpPotion() {
    hp += 10;
  }
}
