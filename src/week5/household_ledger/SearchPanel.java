package week5.household_ledger;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.JobAttributes;
import java.awt.Toolkit;
import java.time.Month;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchPanel extends JPanel {

  JComboBox<String> monthComboBox;
  JComboBox<String> typeComboBox;
  JTextField briefTextFiled;
  JTextField incomeFrom;
  JTextField incomeTo;
  JTextField expensesFrom;
  JTextField expensesTo;

  public SearchPanel() {
    initPanel();
  }

  private void initPanel() {
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();

    setLayout(null);
    setBounds((int) (screenSize.getWidth() * 0.02), (int) (screenSize.getHeight() * 0.03),
        (int) (screenSize.getWidth() * 0.76), (int) (screenSize.getHeight() * 0.12));
    setBackground(Color.LIGHT_GRAY);

    addComponents();
  }


  private void addComponents() {
    JLabel monthLabel = new JLabel("월");
    monthComboBox = new JComboBox<>(
        new String[]{"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"});
    monthLabel.setBounds(50, 20, 20, 20);
    monthComboBox.setBounds(70, 22, 80, 20);

    JLabel typeLabel = new JLabel("소비유형");
    typeComboBox = new JComboBox<>(new String[]{"", "현금", "카드"});
    typeLabel.setBounds(200, 20, 50, 20);
    typeComboBox.setBounds(250, 22, 80, 20);

    JLabel briefLabel = new JLabel("적요");
    briefTextFiled = new JTextField(20);
    briefLabel.setBounds(360, 20, 60, 20);
    briefTextFiled.setBounds(400, 20, 200, 20);

    JButton searchBtn = new JButton("조회");
    JButton resetBtn = new JButton("리셋");
    searchBtn.setBounds((int) (getWidth() * 0.85), 20, 55, 20);
    resetBtn.setBounds((int) (getWidth() * 0.9), 20, 55, 20);
    resetBtn.addActionListener((e) -> {
      resetSearchConditions();
    });

    JLabel incomeLabel = new JLabel("수입");
    incomeFrom = new JTextField(15);
    JLabel tilde = new JLabel("~");
    incomeTo = new JTextField(15);
    incomeLabel.setBounds(40, 50, 40, 20);
    incomeFrom.setBounds(80, 50, 100, 20);
    tilde.setBounds(180, 50, 20, 20);
    incomeTo.setBounds(200, 50, 100, 20);

    JLabel expensesLabel = new JLabel("지출");
    expensesFrom = new JTextField(15);
    JLabel tilde2 = new JLabel("~");
    expensesTo = new JTextField(15);
    expensesLabel.setBounds(320, 50, 40, 20);
    expensesFrom.setBounds(360, 50, 100, 20);
    tilde2.setBounds(460, 50, 20, 20);
    expensesTo.setBounds(480, 50, 100, 20);

    add(monthLabel);
    add(monthComboBox);

    add(typeLabel);
    add(typeComboBox);

    add(briefLabel);
    add(briefTextFiled);

    add(searchBtn);
    add(resetBtn);

    add(incomeLabel);
    add(incomeFrom);
    add(tilde);
    add(incomeTo);

    add(expensesLabel);
    add(expensesFrom);
    add(tilde2);
    add(expensesTo);
  }

  private void resetSearchConditions() {
    monthComboBox.setSelectedIndex(0);
    typeComboBox.setSelectedIndex(0);
    briefTextFiled.setText("");
    incomeFrom.setText("");
    incomeTo.setText("");
    expensesFrom.setText("");
    expensesTo.setText("");
  }
}
