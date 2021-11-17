package week3.day11;

import java.time.LocalDate;

public class ClockThread implements Runnable {

  Clock clock = new Clock();

  @Override
  public void run() {
    while (!Thread.currentThread().isInterrupted()) { //왜 이게 계속 false지? shell에서 INterrupt했는데
      clock.print();

      try {
        Thread.sleep(10 * 1000);
      } catch (InterruptedException e) {
        break;
      }
    }
  }

}
