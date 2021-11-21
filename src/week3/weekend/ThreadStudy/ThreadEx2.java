package week3.weekend.ThreadStudy;

public class ThreadEx2 {

  public static void main(String[] args) {
    //Runnable 인터페이스를 구현한 객체를 하나 생성해서 쓰레드 세 개를 만들던 위 코드와 달리,
    //이번 예제에서는 인터페이스 구현 객체를 세 개 만들고 각각 쓰레드를 만들어 실행.
    SuspendEx2 th1 = new SuspendEx2("*");
    SuspendEx2 th2 = new SuspendEx2("**");
    SuspendEx2 th3 = new SuspendEx2("***");
    th1.start();
    th2.start();
    th3.start();

    try {
      Thread.sleep(2000);
      th1.suspend();
      Thread.sleep(2000);
      th2.suspend();
      Thread.sleep(3000);
      th1.resume();
      Thread.sleep(3000);
      th1.stop();
      th2.stop();
      Thread.sleep(2000);
      th3.stop();

    } catch (InterruptedException e) {}
  }

}
