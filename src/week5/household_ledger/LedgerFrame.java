package week5.household_ledger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class LedgerFrame extends JFrame {

  JPanel tablePanel;
  JTable table;
  JPanel inputPanel;

  public LedgerFrame() {
    initFrame();
    initPanels();
  }

  private void initFrame() {
    setTitle("피오의 가계부");
    setLayout(null);
    setBounds(200, 200, 1500, 800);
  }

  private void initPanels() {
    initTablePanel();
    initInputPanel();
  }

  private void initInputPanel() {
  }

  private void initTablePanel() {
    table = new JTable();

  }

}
