package week3.weekend.ThreadStudy;

public class SuspendEx implements Runnable {

  @Override
  public void run() {
    while (true) {
      System.out.println(Thread.currentThread().getName());
      try {
        Thread.sleep(1000); //1초마다 실행중인 쓰레드의 이름을 출력함.
      } catch (InterruptedException e) {}
    }
  }
}
