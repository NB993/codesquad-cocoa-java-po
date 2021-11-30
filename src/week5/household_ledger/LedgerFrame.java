package week5.household_ledger;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneLayout;

public class LedgerFrame extends JFrame {

  JTable table;
  JPanel inputPanel;
  JPanel tablePanel;

  public LedgerFrame() {
    initFrame();
    initPanels();
    setVisible(true);
  }

  private void initFrame() {
    setTitle("피오의 가계부");
    setLayout(null);

    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    setBounds((int) (screenSize.width * 0.1), (int) (screenSize.height * 0.1),
        (int) (screenSize.width * 0.8), (int) (screenSize.height * 0.8));
  }

  private void initPanels() {
    initInputPanel();
    initTablePanel();
  }

  private void initTablePanel() {
    add(new TablePanel());
  }

  private void initInputPanel() {
    add(new SearchPanel());
  }


}
