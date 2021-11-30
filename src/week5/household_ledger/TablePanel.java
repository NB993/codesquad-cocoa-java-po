package week5.household_ledger;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneLayout;

public class TablePanel extends JPanel {

  JTable table;

  public TablePanel() {
    initPanel();
  }

  private void initPanel() {

    setLayout(null);
    setBounds((int) (this.getWidth() * 0.05), (int) (this.getHeight() * 0.35),
        (int) (this.getWidth() * 0.9), (int) (this.getHeight() * 0.55));
    setBackground(Color.lightGray);

    JButton addBtn = new JButton("추가");
    addBtn.setBounds((int) (getWidth() * 0.85), 0,70, 40);
    JButton editBtn = new JButton("수정");
    editBtn.setBounds((int) (getWidth() * 0.90), 0,70, 40);
    JButton removeBtn = new JButton("삭제");
    removeBtn.setBounds((int) (getWidth() * 0.95), 0,70, 40);

    add(addBtn);
    add(editBtn);
    add(removeBtn);

    String[][] data = {
        {"1", "2", "3", "4", "5"},
        {"6", "7", "8", "9", "10"}
    };
    String[] columns = {"날짜", "수입", "지출", "적요", "타입"};
    table = new JTable(data, columns);
    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setLayout(new ScrollPaneLayout());
    scrollPane.setBounds(0, (int) (getHeight() * 0.10),
        this.getWidth(), (int) (getHeight() * 0.90));

    add(scrollPane);
  }
}
