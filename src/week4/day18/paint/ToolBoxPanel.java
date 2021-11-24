package week4.day18.paint;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.List;

public class ToolBoxPanel extends Panel {
  String[] buttonLabels = {"연필", "직선", "사각형", "원", "세모", "지우개"};
  List<Button> toolsBtn;
  Eraser eraser;
  Pencil pencil;

  public ToolBoxPanel() {
    this.toolsBtn = makeButtons();
    setLayout(new GridLayout(1, 6));
  }

  private List<Button> makeButtons() {
    List<Button> returnButtons = new ArrayList<>();
    for (String label : buttonLabels) {
      returnButtons.add(new Button(label));
    }

    return returnButtons;
  }

  private void initPanel() {

  }
}
