package week3.weekend.ThreadStudy;

public class SuspendEx3 implements Runnable {

  boolean stopped = false;
  boolean suspended = false;

  Thread th;

  public SuspendEx3(String name) {
    th = new Thread(this, name);
  }

  public void start() {
    th.start();
  }
  public void stop() {
    stopped = true;
    th.interrupt(); // 추가 코드
  }
  public void suspend() {
    suspended = true;
    th.interrupt(); // 추가 코드
  }
  public void resume() {
    suspended = false;
  }

  @Override
  public void run() {
    while (!stopped) {
      if (!suspended) {
        System.out.println(Thread.currentThread().getName());
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {}
      } else {
        Thread.yield(); // 추가 코드
      }
    }
  }
}

// ------------------------- 추가된 코드 -------------------------------
// ThreadEx의 main메서드에서 stop()이나 suspend()를 호출했을 때 만약 현재 이 쓰레드가 sleep()상태라면, 남은 sleep 시간이 있을 수 있기 때문에
// 이 쓰레드는 바로 일시정지 되거나, 종료될 수 없다.
// 남아있는 sleep시간 만큼 stop(), suspend()에 대한 반응이 느려지기 때문에 이 쓰레드를 interrupt()로 바로 깨워서
// stop(), suspend()에 즉각 반응할 수 있도록 만들어줄 수 있다.

// ------------------------- 추가된 코드 -------------------------------
//suspend()가 호출되면, 이 쓰레드가 스케줄러에게 할당받은 작업 시간중
//아직 남아 있는 시간을 다른 쓰레드에게 넘겨주고 자기는 실행대기상태(RUNNABLE)로 들어감.
//어차피 아무 일 안할 거니까!

//volatile : 변수값이 쉽게 바뀌는 변수라는 뜻. 붙이는 이유는 CPU의 코어들은 각자 캐시를 가지고 있는데, 캐시들에
//  메모리에 있는 변수의 값을 복사해서 가지고 있다(복사본). 근데 메모리에서는 true로 값이 바뀌었는데 코어의 캐시에 있는 변수값이
//  아직 업데이트가 안돼서 False일 수 있다. volatile을 붙이면 복사본을 사용하지 못하게 하는 거다. 매번 원본의 값을 가져오게 함.
//즉 Volatile은 이 변수의 값이 자주 바뀌니까 복사본 쓰지 말고 매번 원본에서 값을 가져다 쓰라고 지시하기 위한 키워드.
