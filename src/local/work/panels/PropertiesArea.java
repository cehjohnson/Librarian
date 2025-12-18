package local.work.panels;

import javax.swing.*;
import java.awt.*;

public class PropertiesArea extends JPanel {
    private static JLabel label;

    public PropertiesArea() {
        PropertiesArea.label = new JLabel("Properties Area");
        Dimension d = new Dimension(800, 100);

        this.add(label);
//        label.setAlignmentY(0f);
        label.setPreferredSize(d);

        this.setBackground(new Color(255, 170, 0));
    }
}