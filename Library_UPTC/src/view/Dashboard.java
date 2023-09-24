package view;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {
    private Toolkit toolkit;
    private Dimension dimension;
    public Dashboard(){
        toolkit = Toolkit.getDefaultToolkit();
        dimension = toolkit.getScreenSize();
        setSize(dimension);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
