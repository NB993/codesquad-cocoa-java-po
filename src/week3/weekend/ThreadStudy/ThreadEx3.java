package week3.weekend.ThreadStudy;

public class ThreadEx3 {

  public static void main(String[] args) {
    SuspendEx3 th1 = new SuspendEx3("*");
    SuspendEx3 th2 = new SuspendEx3("**");
    SuspendEx3 th3 = new SuspendEx3("***");
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
