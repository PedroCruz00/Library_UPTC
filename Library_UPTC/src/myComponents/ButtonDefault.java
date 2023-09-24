package myComponents;

import javax.swing.*;
import java.awt.*;


public class ButtonDefault extends JFrame {
    JButton button1;

    public ButtonDefault() {

        setLayout(null);
        button1 = new JButton("Cerrar");
        button1.setBounds(300, 250, 100, 30);


        button1.setBackground(new Color(25, 23, 23));
        button1.setForeground(Color.black);
        button1.setFont(new Font("Arial", Font.BOLD, 14));

        add(button1);
    }


    public void Create() {
        ButtonDefault main = new ButtonDefault();
        main.setDefaultCloseOperation(EXIT_ON_CLOSE);
        main.setBounds(0, 0, 450, 350);
        main.setVisible(true);
        main.setResizable(false);
        main.setLocationRelativeTo(null);

    }

}
