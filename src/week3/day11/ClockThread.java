package week3.day11;

public class ClockThread extends Thread {
  Clock clock = new Clock();

  @Override
  public void run() {
    while (!interrupted()) {
      clock.print();

      try {
        Thread.sleep(5 * 1000);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }

}
