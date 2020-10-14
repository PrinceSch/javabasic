package lesson7a;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {
    public MyWindow() {
        setBounds(200, 300, 800, 600);
        setTitle("MyWindow");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JButton button1 = new JButton("button1");
        add(button1, BorderLayout.NORTH);

        JButton button2 = new JButton("button2");
        add(button2, BorderLayout.EAST);

        JTextArea textArea = new JTextArea();
        add(textArea, BorderLayout.CENTER);

        JTextField textField = new JTextField();
        add(textField, BorderLayout.SOUTH);


        button1.addActionListener(e -> {
            textArea.append("button1 clicked\n");
        });

        button2.addActionListener(e -> {
            textArea.append(textField.getText()+"\n");
            textField.setText("");
            textField.requestFocus();
        });

        setVisible(true);
    }
}
