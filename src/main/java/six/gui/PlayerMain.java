package org.akademija.six.gui;

import org.akademija.six.gui.ui.PlayerPanel;

import javax.swing.*;

public class PlayerMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(PlayerMain::createAndShowGUI);
    }

    private static void createAndShowGUI(){
        JFrame frame = new JFrame("Players");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        PlayerPanel playerPanel = new PlayerPanel();
        frame.setContentPane(playerPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
