package view.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMenuItem extends JMenu implements MouseListener{
    private Dimension dimension;
    private Toolkit toolkit;
    public MyMenuItem(String text){
        setText(text);
        toolkit = Toolkit.getDefaultToolkit();
        dimension = toolkit.getScreenSize();
        this.setForeground(Color.white);
        this.setHorizontalTextPosition(this.CENTER);
        setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        setPreferredSize(new Dimension(dimension.width/4,40));
        addMouseListener(this);
        setColor(Color.GRAY);
    }



    public void setColor(Color color){
        setOpaque(true);
        setBackground(color);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        setColor(Color.GRAY);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        setColor(Color.GRAY);
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        setColor(Color.GRAY);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setColor(Color.darkGray);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setColor(Color.GRAY);
    }

}
