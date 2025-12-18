package local.work.panels;

import javax.swing.*;
import java.awt.*;

public class FileTreeArea extends JPanel{
    private static JLabel label;

    public FileTreeArea() {
        FileTreeArea.label = new JLabel("File Tree Area");
        Dimension d = new Dimension(100, 200);

        this.add(label);
//        label.setAlignmentY(0f);
        label.setPreferredSize(d);

        this.setBackground(new Color(140, 71, 170));
    }
}