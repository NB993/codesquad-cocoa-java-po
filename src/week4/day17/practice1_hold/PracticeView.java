package week4.day17.practice1;

import java.awt.*;

public class PracticeView extends View {
  private Controller controller;
  private Frame frame;
  private Component[] componentsOfView;


  public PracticeView(int width, int height)
      throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    super(width, height);
  }

  public PracticeView()
      throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    super();
  }
}
