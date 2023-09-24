package view.menu;

import javax.swing.*;
import java.awt.*;

public class DeleteBook extends JPanel {
    private JLabel isbn;
    private JTextField inputISBN;
    private JComboBox campus;

    public DeleteBook() {
        initComponents();
    }
    public void initComponents(){
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        isbn = new JLabel("Ingrese el ISBN del libro a eliminar");
        add(isbn,constraints);
        constraints.gridx = 1;
        inputISBN = new JTextField(20);
        add(inputISBN,constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        campus = new JComboBox();
        add(campus,constraints);
    }

}
