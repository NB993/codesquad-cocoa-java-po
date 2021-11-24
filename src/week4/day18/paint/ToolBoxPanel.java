package week4.day18.paint;

import java.awt.Button;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Paint;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.undo.UndoManager;

public class ToolBoxPanel extends Panel {

  private final String[] buttonLabels = {"연필", "직선", "사각형", "원", "세모", "지우개"};
  private final List<Button> toolBtns;
  private AdapterMouseListener mouseListener;

  public ToolBoxPanel() {
    this.toolBtns = makeButtons();
    initPanel();
    addButtonActionEventListener();
  }

  private List<Button> makeButtons() {
    List<Button> returnButtons = new ArrayList<>();
    for (String label : buttonLabels) {
      returnButtons.add(new Button(label));
    }

    return returnButtons;
  }

  private void initPanel() {
    setLayout(new GridLayout(1, 6));
    setBounds(0, 30, 1024, 100);
    for (Button toolBtn : toolBtns) {
      this.add(toolBtn);
    }
  }

  public void addButtonActionEventListener() {
    for (Button toolBtn : toolBtns) {
      toolBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          removeMouseListenerFromPaintFrame(e);
          addMouseListenerToPaintFrame(e);
        }
      });
    }
  }

  private void removeMouseListenerFromPaintFrame(ActionEvent e) {
    Button btn = (Button) e.getSource();
    PaintFrame paintFrame = (PaintFrame) btn.getParent().getParent();
    paintFrame.removeMouseMotionListener(mouseListener);
    paintFrame.removeMouseListener(mouseListener);
  }

  private void addMouseListenerToPaintFrame(ActionEvent e) {
    Button btn = (Button) e.getSource();
    PaintFrame paintFrame = (PaintFrame) btn.getParent().getParent();
    Graphics graphics = paintFrame.getPaintFrameGraphics();
    Graphics2D graphics2D = paintFrame.getPaintFrameGraphics2D();

    switch (btn.getLabel()) {
      case "연필":
        mouseListener = new AdapterMouseListener() {
          @Override
          public void mouseMoved(MouseEvent e) {
            paintFrame.setX(e.getX());
            paintFrame.setY(e.getY());
          }

          @Override
          public void mouseDragged(MouseEvent e) {
            if (e.getModifiersEx() != MouseEvent.BUTTON1_DOWN_MASK) {
              return;
            }
            graphics.drawLine(paintFrame.getX(), paintFrame.getY(), e.getX(), e.getY());
            paintFrame.setX(e.getX());
            paintFrame.setY(e.getY());
          }
        };
        paintFrame.addMouseMotionListener(mouseListener);
        break;
      case "직선":
        mouseListener = new AdapterMouseListener() {
          @Override
          public void mouseDragged(MouseEvent e) {
            //TODO: 마우스 드래그시 출발점부터 마우스 포인터까지 계속 선이 따라다니도록 구현. 선이 마구 생기면 안됨.
          }

          @Override
          public void mousePressed(MouseEvent e) {
            paintFrame.setX(e.getX());
            paintFrame.setY(e.getY());
          }

          @Override
          public void mouseReleased(MouseEvent e) {
            graphics.drawLine(paintFrame.getX(), paintFrame.getY(), e.getX(), e.getY());
          }
        };
        paintFrame.addMouseMotionListener(mouseListener);
        paintFrame.addMouseListener(mouseListener);
        break;
      case "사각형":
        break;
      case "원":
        break;
      case "세모":
        break;
      case "지우개":
        mouseListener = new AdapterMouseListener() {
          @Override
          public void mouseDragged(MouseEvent e) {

          }
        };
        break;

    }
  }
}
