package week3.weekend.ThreadStudy;

public class SuspendEx2 implements Runnable {

  //직접 구현한 suspend(), stop()메서드에 이용할 플래그 멤버 변수
  boolean stopped = false;
  boolean suspended = false;

  Thread th; //Runnable 구현체 안에서 쓰레드를 가지고 있고, 이 멤버변수로 쓰레드를 실행한다.

  public SuspendEx2(String name) {
    th = new Thread(this, name);
  }

  //우리는 Thread의 원래 Suspend()와 stop()을 이용하지 않을 것이다. 교착상태를 일으킬 수 있기 때문에.
  //그래서 Runnable 인터페이스 구현클래스를 이용할 건데, Runnable인터페이스에는 run() 추상메서드밖에 없기 때문에
  //start / suspend / resume / stop 메서드를 직접 구현해야만 한다.

  public void start() {
    th.start();
  }
  public void stop() {
    stopped = true;
  }
  public void suspend() {
    suspended = true;
  }
  public void resume() {
    suspended = false;
  }

  @Override
  public void run() {
    while (!stopped) {

      //suspend가 호출되어도 stop이 호출되지 않으면 while반복문을 계속 실행하므로 스레드가 종료되지 않는다.
      //suspend()이후 resume()이 호출되었다면 다시 if 문을 수행할 수 있게 된다.
      if (!suspended) {
        System.out.println(Thread.currentThread().getName());
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {}

      }
    }
  }
}


//volatile : 변수값이 쉽게 바뀌는 변수라는 뜻. 붙이는 이유는 CPU의 코어들은 각자 캐시를 가지고 있는데, 캐시들에
//  메모리에 있는 변수의 값을 복사해서 가지고 있다(복사본). 근데 메모리에서는 true로 값이 바뀌었는데 코어의 캐시에 있는 변수값이
//  아직 업데이트가 안돼서 False일 수 있다. volatile을 붙이면 복사본을 사용하지 못하게 하는 거다. 매번 원본의 값을 가져오게 함.
//즉 Volatile은 이 변수의 값이 자주 바뀌니까 복사본 쓰지 말고 매번 원본에서 값을 가져다 쓰라고 지시하기 위한 키워드.
