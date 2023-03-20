package two.gui;

import javax.swing.*;
import java.awt.*;

public class GeekMain {
    public static void main(String[] args) {
       // Runnable runnable=GeekMain::CreateAndShowGUI;
        SwingUtilities.invokeLater(GeekMain::CreateAndShowGUI);

    }

    static void CreateAndShowGUI() {
        JFrame frame=new JFrame("Geek for geeks");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel geekpanel=new GeekPanel();
        frame.setContentPane(geekpanel);
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(400,300));
    }
}
