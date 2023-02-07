package first_package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ButtonPanel extends JPanel {

    private final JButton leftButton=new JButton("Disable middle button");
    private final JButton middleButton=new JButton("Middle Button");
    private final JButton rightButton=new JButton("Enable middle Button");

    public ButtonPanel(){
        add(leftButton);
        add(middleButton);
        add(rightButton);
        init();
        setLayout(new FlowLayout());
    }
    private void init(){
        leftButton.setEnabled(true);
        middleButton.setEnabled(true);
        rightButton.setEnabled(false);
        leftButton.addActionListener(new LeftButtonActionListener());
        leftButton.setMnemonic(KeyEvent.VK_LEFT);
        rightButton.addActionListener(new RightButtonActionListener());
        rightButton.setMnemonic(KeyEvent.VK_RIGHT);
    }
private class LeftButtonActionListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        leftButton.setEnabled(false);
        middleButton.setEnabled(false);
        rightButton.setEnabled(true);
    }
}
private class RightButtonActionListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        leftButton.setEnabled(true);
        middleButton.setEnabled(true);
        rightButton.setEnabled(false);
    }
}
}
