package week3.weekend.ThreadStudy;

public class ThreadEx4 {

  public static void main(String[] args) {
    System.out.println("main쓰레드 시작");
    JoinEx th = new JoinEx();
    th.start();
    try {
      th.join();
    } catch (InterruptedException e) {
    }
//    try {
//      Thread.currentThread().join();
//    } catch (InterruptedException e) {}
//
//    for (int i = 1; i <= 10; i++) {
//      System.out.println("main : " + i);
//    }
    System.out.println("main쓰레드 종료");


  }
}
