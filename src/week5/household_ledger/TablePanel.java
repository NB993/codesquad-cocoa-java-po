package week5.household_ledger;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TablePanel extends JPanel {

  JDialog addItemDialog;
  DefaultTableModel ledgerModel;
  JTable table;

  public TablePanel() {
    initPanel();
  }

  private void initPanel() {
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    setLayout(null);
    setBounds((int) (screenSize.getWidth() * 0.02), (int) (screenSize.getHeight() * 0.18),
        (int) (screenSize.getWidth() * 0.76), (int) (screenSize.getHeight() * 0.55));
    setBackground(Color.LIGHT_GRAY);

    addButtons();
    addTable();
  }


  private void addButtons() {
    JButton addBtn = new JButton("추가");
    addBtn.setBounds((int) (getWidth() * 0.85), 3, 55, 35);
    addBtn.addActionListener((e) -> {
      addItemDialog = new LedgerAddDialog();
    });
    JButton editBtn = new JButton("수정");
    editBtn.setBounds((int) (getWidth() * 0.90), 3, 55, 35);
    JButton removeBtn = new JButton("삭제");
    removeBtn.setBounds((int) (getWidth() * 0.95), 3, 55, 35);

    add(addBtn);
    add(editBtn);
    add(removeBtn);
  }

  private void addTable() {
    ledgerModel = makeLedgerModel();
    table = new JTable(ledgerModel);
    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setLayout(new ScrollPaneLayout());
    scrollPane.setBounds(0, (int) (getHeight() * 0.08),
        getWidth(), (int) (getHeight() * 0.92));

    add(scrollPane);
  }

  private DefaultTableModel makeLedgerModel() {
    List<String[]> fileData = new ArrayList<>();
    String[] columns = {"날짜", "수입", "지출", "적요", "타입"};
    try {
      fileData = loadTextFile();
    } catch (IOException e) {
      System.out.println(e.getMessage());
      return null;
    }

    String[][] modelData = new String[fileData.size()][];
    for (int i = 0; i < fileData.size(); i++) {
      modelData[i] = fileData.get(i);
    }
    return new LedgerModel(modelData, columns);
  }

  private List<String[]> loadTextFile() throws IOException {
    String path = LedgerModel.class.getResource("").getPath();
    FileReader fr = new FileReader(path + "ledger.txt", Charset.forName("UTF-8"));
    BufferedReader br = new BufferedReader(fr);

    List<String[]> txtData = new ArrayList<>();
    String singleLine = "";
    while ((singleLine = br.readLine()) != null) {
      txtData.add(singleLine.split(";"));
    }
    br.close();

    return txtData;
  }

  private class LedgerAddDialog extends JDialog {

    JPanel addPanel = new JPanel();
    JTextField date;
    JTextField income;
    JTextField expenses;
    JTextField brief;
    JComboBox<String> type;

    public LedgerAddDialog() {
      initDialog();
    }

    private void initDialog() {
      setTitle("추가");
      setLayout(null);

      Toolkit tk = Toolkit.getDefaultToolkit();
      Dimension screenSize = tk.getScreenSize();
      setBounds((int) (screenSize.width * 0.4), (int) (screenSize.height * 0.3),
          (int) (screenSize.width * 0.2), (int) (screenSize.height * 0.4));
      setModal(true);

      initPanels();
      setVisible(true);
    }

    private void initPanels() {
      addPanel = new JPanel();
      addPanel.setLayout(new GridLayout(6, 2));
      addPanel.setBounds(0, 0, getWidth(), getWidth());
      addTextFieldsToPanel();
      add(addPanel);
    }

    private void addTextFieldsToPanel() {
      addPanel.add(new JLabel("날짜"));
      String today = LocalDate.now() + "";
      date = new JTextField(today);
      addPanel.add(date);
      addPanel.add(new JLabel("수입"));
      income = new JTextField();
      addPanel.add(income);
      addPanel.add(new JLabel("지출"));
      expenses = new JTextField();
      addPanel.add(expenses);
      addPanel.add(new JLabel("적요"));
      brief = new JTextField();
      addPanel.add(brief);
      addPanel.add(new JLabel("타입"));
      type = new JComboBox<String>(new String[]{"현금", "카드"});
      addPanel.add(type);
      JButton okBtn = new JButton("확인");
      okBtn.addActionListener((e) -> {
        addRowToModel();
        dispose();
      });
      addPanel.add(okBtn);
    }

    private void addRowToModel() {
      ledgerModel.addRow(new String[]{
          date.getText(),
          income.getText(),
          expenses.getText(),
          brief.getText(),
          (String)type.getSelectedItem()
      });

    }

  }

}

