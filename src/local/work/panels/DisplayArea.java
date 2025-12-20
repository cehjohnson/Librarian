package local.work.panels;

import javax.swing.*;
import java.awt.*;

public class DisplayArea extends JPanel{
    private static JLabel label;

    public static JLabel getLabel() {
        return label;
    }

    public static void setLabel(JLabel label) {
        DisplayArea.label = label;
    }

    public DisplayArea() {
        this.setBackground(Color.PINK);
        DisplayArea.label = new JLabel("Display Area");

        this.add(label);
        label.setAlignmentY(0.5f);
    }
}
