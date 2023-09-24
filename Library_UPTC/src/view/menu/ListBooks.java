package view.menu;

import javax.swing.*;
import java.awt.*;

public class ListBooks extends JPanel {

    private JTable table;
    private Object[][]data;
    private String[]column;

    public ListBooks() {
        //Object[][] data, String[] column
        this.data = new Object[][]{};
        this.column = new  String[]{"Titulo","Nombre","ISBN","Sede"};
        initComponents();
    }


    public void initComponents(){
        table = new JTable(data, column);
        table.setBackground(new Color(84, 94, 103));
        table.setFont(new Font(Font.DIALOG, Font.BOLD, 10));
        table.setForeground(Color.WHITE);
        this.add(table);

    }

}
