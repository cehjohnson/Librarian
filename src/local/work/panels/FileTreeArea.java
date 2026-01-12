package local.work.panels;

import local.work.Brain;
import local.work.datahandlers.LabelHander;
import local.work.datahandlers.TreeStreamParser;

import javax.swing.*;
import java.awt.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;

public class FileTreeArea extends JPanel implements BrainClient, LabelHander {
    private static JLabel label;
    private static Brain brain;

    public static JLabel getLabel() {
        return label;
    }

    public static void setLabel(String t) {
        label.setText(t);
    }

    @Override
    public void setBrain(Brain brain) {
        this.brain = brain;
    }

   public void start() {
       TreeStreamParser parser = new TreeStreamParser(brain.getContents(), this);
       parser.execute();
   }

   @Override
   public void handleLabel(JLabel label) {
        SwingUtilities.invokeLater(() -> {
            this.add(label);
            this.revalidate();
            this.repaint();
        });
   }

    @Override
    public void update() {}

    @Override
    public void update(String u) {
        setLabel(u);
        start();
    }

    public FileTreeArea() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.YELLOW);
        this.label = new JLabel("File Tree Area");

        this.add(label);
    }
}