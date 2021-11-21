package week3.weekend.ThreadStudy;

public class ThreadEx {

  public static void main(String[] args) {
    SuspendEx sus = new SuspendEx();
    Thread th1 = new Thread(sus, "*");
    Thread th2 = new Thread(sus, "**");
    Thread th3 = new Thread(sus, "***");
    th1.start();
    th2.start();
    th3.start();

    try {
      Thread.sleep(2000); //메인스레드가 실행되고 2초후에
      th1.suspend(); // th1을 일시정지 시키고
      Thread.sleep(2000); //다시 2초 후에
      th2.suspend(); // th2를 일시정지
      Thread.sleep(3000); //3초 후에
      th1.resume(); // th1의 작업을 재개시키고
      Thread.sleep(3000); //...
      th1.stop(); //th1을 아예 중지시킨다. 이제 더이상 콘솔에 "*"는 찍히지 않는다.
      th2.stop(); //th2도 중지되어 이 시점부터는 "***"만 찍히게 된다.
      Thread.sleep(2000);
      th3.stop(); //작업이 끝났다.

    } catch (InterruptedException e) {}
  }

}
