package lesson7a;

import javax.swing.*;
import java.awt.*;

public class MyWindow2 extends JFrame {
    public MyWindow2() {
        setBounds(200, 300, 800, 600);
        setTitle("MyWindow");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setLayout(new FlowLayout());
//        setLayout(new GridLayout(3,3));
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(1,10));

        for (int i = 1; i < 10; i++) {
            JButton button1 = new JButton("button" + i);
            panel.add(button1);
        }

        add(panel,BorderLayout.SOUTH);

        setVisible(true);
    }
}
