package week4.day17.practice1;

public class Main {

  public static void main(String[] args) {
    View practiceView;
    try {
      practiceView = new PracticeView();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }
}
