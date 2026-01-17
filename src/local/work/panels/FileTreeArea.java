package local.work.panels;

import local.work.Brain;
import local.work.datahandlers.WorkerOutputHandler;
import local.work.datahandlers.TreeStreamParser;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;

public class FileTreeArea extends JPanel implements BrainClient, ActionListener, WorkerOutputHandler {
    private static JLabel label;
    private static Brain brain;
    private static GroupLayout layout;
    private static GroupLayout.ParallelGroup hgroup;
    private static GroupLayout.SequentialGroup vgroup;

    @Override
    public void actionPerformed(@NotNull ActionEvent ae) {
        String toBePassed = ae.getActionCommand();
        if (brain.getCurrentLocation().equals(brain.getRootDir())) {
            try {
                brain.publish(brain.getCurrentLocation() + toBePassed);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                brain.publish(brain.getCurrentLocation() + '/' + toBePassed);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static JLabel getLabel() {
        return label;
    }

    @Override
    public void handleParserOutput(JComponent c) {
        SwingUtilities.invokeLater(() -> {
            this.layout = new GroupLayout(this);
            this.setLayout(layout);
            layout.setAutoCreateGaps(true);
            layout.setAutoCreateContainerGaps(true);
            this.hgroup = layout.createParallelGroup();
            this.vgroup = layout.createSequentialGroup();
            hgroup.addGroup(layout.createParallelGroup().addComponent(label));
            hgroup.addGroup(layout.createParallelGroup().addComponent(c));
            vgroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(label));
            vgroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(c));
            layout.setHorizontalGroup(hgroup);
            layout.setVerticalGroup(vgroup);
            this.revalidate();
            this.repaint();
        });
    }

    public static void setLabel(String t) {
        label.setText(t);
    }

    @Override
    public void setBrain(Brain brain) {
        this.brain = brain;
    }

   public void start() {
        DirectoryStream<Path> ds = brain.getContents();
        if (ds != null) {
            TreeStreamParser parser = new TreeStreamParser(ds, this, this);
            parser.execute();
        }
        else {
            System.out.println("No Directory Stream returned!");
        }
   }

    @Override
    public void update() {}

    @Override
    public void update(String u) {
        this.removeAll();
        ImageIcon icon = new ImageIcon("src/resources/open-folder.png");
        this.label = new JLabel(u);
        label.setIcon(icon);
        label.setHorizontalAlignment(SwingConstants.LEFT);

        start();
    }

    public FileTreeArea() {
        this.setBackground(Color.YELLOW);
    }
}
