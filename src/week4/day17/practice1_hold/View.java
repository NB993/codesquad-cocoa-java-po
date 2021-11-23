package week4.day17.practice1;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.io.File;

public class View {

  private static final int DEFAULT_FRAME_WIDTH = 980;
  private static final int DEFAULT_FRAME_HEIGHT = 540;

  private Frame frame;
  private Controller controller;

  public View(int width, int height)
      throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    this.frame = initFrame(width, height);
    this.controller = findController();
  }

  public View() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    this(DEFAULT_FRAME_WIDTH, DEFAULT_FRAME_HEIGHT);
  }


  private Frame initFrame() {
    return initFrame(DEFAULT_FRAME_WIDTH, DEFAULT_FRAME_HEIGHT);
  }

  private Frame initFrame(int width, int height) {
    Frame frame = new Frame();
    frame.setLayout(null);
    frame.setSize(width, height);

    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    frame.setLocation((screenSize.width / 2) - (width / 2), (screenSize.height / 2) - (height / 2));

    return frame;
  }

  public Controller findController()
      throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    String currPath = this.getClass().getResource(".").getPath();
    File currrentPathDir = new File(currPath);
    File[] files = currrentPathDir.listFiles();
    String thisViewName = this.getClass().getSimpleName();
    thisViewName = thisViewName.substring(0, thisViewName.indexOf("View"));

    String controllerName;
    for (int i = 0; i < files.length; i++) {
      if ((files[i].getPath().substring(files[i].getPath().lastIndexOf("/") + 1)).equals(
          thisViewName + ".class")) {
        controllerName = thisViewName + "Controller";
        Class<?> clazz = Class.forName(controllerName);
        return (Controller) clazz.newInstance();
      }
    }

    return null;
  }

  public Controller getController() {
    return controller;
  }

  public Frame getFrame() {
    return frame;
  }

}
