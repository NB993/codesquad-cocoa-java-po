package week5.household_ledger;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class SearchPanel extends JPanel {

  public SearchPanel() {
    initPanel();
  }



  private void initPanel() {
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();

    setLayout(null);
    setBounds((int)(screenSize.getWidth() * 0.02), (int)(screenSize.getHeight() * 0.03),
        (int) (screenSize.getWidth() * 0.76), (int) (screenSize.getHeight() * 0.12));
    setBackground(Color.LIGHT_GRAY);
  }
}
