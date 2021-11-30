package week5.household_ledger;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
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
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();

    setLayout(null);
    setBounds((int)(screenSize.getWidth() * 0.02), (int)(screenSize.getHeight() * 0.18),
        (int) (screenSize.getWidth() * 0.76), (int) (screenSize.getHeight() * 0.55));
    setBackground(Color.LIGHT_GRAY);

    JButton addBtn = new JButton("추가");
    addBtn.setBounds((int) (getWidth() * 0.85), 3,55, 35);
    JButton editBtn = new JButton("수정");
    editBtn.setBounds((int) (getWidth() * 0.90), 3,55, 35);
    JButton removeBtn = new JButton("삭제");
    removeBtn.setBounds((int) (getWidth() * 0.95), 3,55, 35);

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
    scrollPane.setBounds(0, (int) (getHeight() * 0.08),
        getWidth(), (int) (getHeight() * 0.92));

    add(scrollPane);
  }
}
