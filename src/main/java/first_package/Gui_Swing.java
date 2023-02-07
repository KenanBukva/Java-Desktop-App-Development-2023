package first_package;

import javax.swing.*;

public class Gui_Swing {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(600, 600);
        frame.setTitle("Prvi prozor GUI-Swing");

        ButtonPanel buttonPanel=new ButtonPanel();
        frame.setContentPane(buttonPanel);
        frame.setVisible(true);

    }
}
