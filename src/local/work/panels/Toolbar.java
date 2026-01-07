package local.work.panels;

import local.work.Brain;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel implements BrainClient, ActionListener {
    private static JButton homeBtn;
    private static ImageIcon homeIcon;
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
        if (e.getSource() == homeBtn) {
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

    private @NotNull ImageIcon setIconSize(ImageIcon icon) {
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }

    public Toolbar() {
        super();

        Toolbar.homeIcon = new ImageIcon(getClass().getResource("../../../resources/home-2504.png"));
        Toolbar.homeBtn = new JButton(Toolbar.homeIcon);
        Toolbar.homeBtn.setPreferredSize(Toolbar.iconSize);
        Toolbar.homeBtn.addActionListener(this);

        Toolbar.d = new Dimension(500, 25);
        Toolbar.addressBar = new JTextField();
        addressBar.setPreferredSize(d);

        this.add(homeBtn);
        this.add(addressBar);
        this.setBackground(Color.RED);
    }
}
