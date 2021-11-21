package week3.weekend.ThreadStudy;

public class ThreadEx5 {

  public static void main(String[] args) {
    JoinEx th1 = new JoinEx();
    th1.start();

    for (int i = 0; i < 20; i++) {
      // 몬스터가 존재하지 않는다면
      if (th1.getMonsterCount() <= 0) {
        // 스레드를 깨워서 몬스터를 생성하도록 시킨다.
        th1.interrupt();
        try {
          // 스레드가 몬스터를 생성할 동안은 기다려준다.
          th1.join(2000);
        } catch (InterruptedException e) {}
      }

      // 메인스레드에서는 3초마다 몬스터를 하나씩 잡는다.
//      try {
//        Thread.sleep(2 * 1000);
        th1.killMonster();
//      } catch (InterruptedException e) {}
    }

  }
}
