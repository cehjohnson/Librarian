package local.work;

import local.work.panels.DisplayArea;
import local.work.panels.FileTreeArea;
import local.work.panels.PropertiesArea;
import local.work.panels.Toolbar;

import javax.swing.*;
import java.awt.*;

public class Window extends JPanel{

    private static Toolbar toolbar;
    private static DisplayArea displayArea;
    private static FileTreeArea fileTreeArea;
    private static PropertiesArea propertiesArea;

    public Window() {
        Window.toolbar = new Toolbar();
        Window.displayArea = new DisplayArea();
        Window.fileTreeArea = new FileTreeArea();
        Window.propertiesArea = new PropertiesArea();

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(toolbar, gbc);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(fileTreeArea, gbc);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(displayArea, gbc);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 2;
        gbc.gridy = 2;
        this.add(propertiesArea, gbc);
    }
}