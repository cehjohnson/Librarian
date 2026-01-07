package local.work.panels;

import local.work.Brain;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel implements BrainClient, ActionListener {
    private static JButton button;
    private static JTextField addressBar;
    private static Brain brain;
    private static Dimension d;


    public static String getAddressBar() {
        return addressBar.getText();
    }

    public static void setAddressBar(String t) {
        addressBar.setText(t);
    }

    @Override
    public void setBrain(Brain brain) {
        this.brain = brain;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = getSendInfo();
        if (e.getSource() == button) {
            brain.publish(s);
        }
    }

    public String getSendInfo() {
        return "String set!";
    }


    @Override
   public void update() {}

    @Override
    public void update(String u) {
        setAddressBar(u);
    }

    public Toolbar() {
        super();
        Toolbar.button = new JButton("Click Me!");
        Toolbar.button.addActionListener(this);
        Toolbar.d = new Dimension(500, 25);
        Toolbar.addressBar = new JTextField();
        addressBar.setPreferredSize(d);

        this.add(button);
        this.add(addressBar);
        this.setBackground(Color.RED);
    }
}
