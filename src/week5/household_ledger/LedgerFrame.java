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
    initTablePanel();
    initInputPanel();
  }

  private void initTablePanel() {
    JPanel tablePanel = new JPanel();
    tablePanel.setLayout(null);
    tablePanel.setBounds((int) (this.getWidth() * 0.05), (int) (this.getHeight() * 0.35),
        (int) (this.getWidth() * 0.9), (int) (this.getHeight() * 0.55));
    tablePanel.setBackground(Color.lightGray);

    JButton addBtn = new JButton("추가");
    addBtn.setBounds((int) (tablePanel.getWidth() * 0.85), 0,70, 40);
    JButton editBtn = new JButton("수정");
    editBtn.setBounds((int) (tablePanel.getWidth() * 0.90), 0,70, 40);
    JButton removeBtn = new JButton("삭제");
    removeBtn.setBounds((int) (tablePanel.getWidth() * 0.95), 0,70, 40);

    tablePanel.add(addBtn);
    tablePanel.add(editBtn);
    tablePanel.add(removeBtn);

    String[][] data = {
        {"1", "2", "3", "4", "5"},
        {"6", "7", "8", "9", "10"}
    };
    String[] columns = {"날짜", "수입", "지출", "적요", "타입"};
    table = new JTable(data, columns);
    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setLayout(new ScrollPaneLayout());
    scrollPane.setBounds(0, (int) (tablePanel.getHeight() * 0.10),
        this.getWidth(), (int) (tablePanel.getHeight() * 0.90));

    tablePanel.add(scrollPane);
    add(tablePanel);
  }

  private void initInputPanel() {
    inputPanel = new JPanel();
  }


}
