package view.menu;

import javax.swing.*;
import java.awt.*;

public class ListBooks extends JPanel {

    private JTable table;
    private Object[][]data;
    private String[]column;

    public ListBooks() {
        setLayout(new GridLayout());
        setBackground(new Color(241, 239, 239));
        this.column = new  String[]{"Titulo","Autor","ISBN","Sede"};
        this.data = new Object[][]{new Object[]{"Cien años de soledad","Gabriel Garcia Marquez",412, "Duitama"},
                {"Cien años de soledad","Gabriel Garcia Marquez",412, "Duitama"}
        };

        initComponents();
    }

    public void initComponents(){
        table = new JTable(data, column);
        table.setBackground(new Color(25, 23, 23));
        table.setFont(new Font(Font.DIALOG, Font.BOLD, 10));
        table.setForeground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);
    }

}
