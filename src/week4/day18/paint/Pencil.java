package week4.day18.paint;

import java.awt.Component;

public class Pencil extends Component {
  private int size;
  private String pencilType; //TODO: enum으로 관리할 수 있으면 해보기.

  public Pencil() {
    this.size = 10;
    this.pencilType = "●";
  }
}

