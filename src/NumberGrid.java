// The following code was written by Angelo Lu (20011350) and Hayden Pfeiffer (20014849)

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class NumberGrid extends JPanel {
    JLabel[][] panel_array;
    GridLayout myGridLayout = new GridLayout(0, 10);
    Color defBG = new Color(238, 189, 49);
    Color disabledBG = new Color(157, 25, 57);

    public NumberGrid() {
        LineBorder defBorder = new LineBorder(new Color(0, 0, 0), 1);
        this.setLayout(myGridLayout);
        this.setBorder(defBorder);
        panel_array = new JLabel[9][10];
        for (int i = 0; i < panel_array.length; i++) {
            for (int j = 0; j < panel_array[i].length; j++) {
                JLabel jlTemp = new JLabel();
                jlTemp.setText((i + 1) * 10 + j + "");
                jlTemp.setPreferredSize(new Dimension(40, 40));
                jlTemp.setBorder(defBorder);
                jlTemp.setOpaque(true);
                jlTemp.setHorizontalAlignment(SwingConstants.CENTER);
                panel_array[i][j] = jlTemp;
                this.add(panel_array[i][j]);
            }
        }
        resetColors();
    }

    private void setBGColor(int num, Color c) {
        if (num < 100 && num >= 10) panel_array[num / 10 - 1][num - (num / 10 * 10)].setBackground(c);
    }

    public void resetColors() {
        for (int i = 0; i < 100; i++) setBGColor(i, defBG);
        for (int i = 1; i < 10; i++) setBGColor(i * 10 + i, disabledBG);
    }

    public void selectRow(int num) {
        for (int i = 0; i < panel_array[num / 10 - 1].length; i++) setBGColor(num / 10 * 10 + i, disabledBG);
    }

    public void selectColumn(int num) {
        for (int i = 1; i <= panel_array.length; i++) setBGColor(i * 10 + num - (num / 10 * 10), disabledBG);
    }
}
