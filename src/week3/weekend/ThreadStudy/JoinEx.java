package week3.weekend.ThreadStudy;

public class JoinEx extends Thread {

  Hero hero = new Hero();
  int monsterCount = 3;

  @Override
  public void run() {
    try {
      Thread.sleep(3 * 1000);
    } catch(InterruptedException e) {
      System.out.println("몬스터를 강제로 생성시작");
    }
    makeMonster();
  }

  private void makeMonster() {
    System.out.print("몬스터를 생성합니다. ");
    monsterCount++;
    System.out.println("남은 몬스터 수 : " + monsterCount);
  }

  public int getMonsterCount() {
    return monsterCount;
  }

  public void killMonster() {
    System.out.println("몬스터를 한마리 죽였습니다.");
    monsterCount--;
    System.out.println("남은 몬스터 수 : " + monsterCount);
  }
}
