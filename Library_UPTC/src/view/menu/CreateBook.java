package view.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreateBook extends JPanel {

    private JLabel title;
    private JTextField inputTitle;
    private JLabel isbn;
    private JTextField inputISBN;
    private JLabel volume;
    private JTextField inputVolume;
    private JComboBox library;
    private JComboBox campus;
    private JLabel nameAutor;
    private JTextField inputNameAutor;
    private JLabel lastNameAutor;
    private JTextField inputLastNameAutor;
    private JLabel biographyAutor;
    private JTextField inputBiographyAutor;
    private JButton create;

    public CreateBook(ActionListener listener) {
        initComponents(listener);
    }

    public void initComponents(ActionListener listener){
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        title = new JLabel("Ingrese el titulo del libro: ");
        add(title,constraints);
        constraints.gridx =1;
        inputTitle = new JTextField(20);
        add(inputTitle,constraints);

        constraints.gridx =0;
        constraints.gridy =1;
        isbn = new JLabel("Ingrese el ISBN del libro: ");
        add(isbn,constraints);
        constraints.gridx =1;
        inputISBN = new JTextField(20);
        add(inputISBN,constraints);

        constraints.gridx =0;
        constraints.gridy =2;
        volume = new JLabel("Volumen del libro: ");
        add(volume,constraints);

        constraints.gridx =1;
        inputVolume = new JTextField(20);
        add(inputVolume,constraints);


        constraints.gridx =0;
        constraints.gridy =3;
        nameAutor = new JLabel("Nombre del autor: ");
        add(nameAutor,constraints);
        constraints.gridx =1;
        inputNameAutor = new JTextField(20);
        add(inputNameAutor,constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        lastNameAutor = new JLabel("Apellido del autor: ");
        add(lastNameAutor,constraints);
        constraints.gridx = 1;
        inputLastNameAutor = new JTextField(20);
        add(inputLastNameAutor,constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        biographyAutor = new JLabel("Biografia del autor: ");
        constraints.gridx = 1;
        inputBiographyAutor = new JTextField(20);

        constraints.gridy = 6;
        constraints.gridx = 0;
        library = new JComboBox();
        add(library,constraints);

        constraints.gridy = 7;
        campus = new JComboBox();
        add(campus,constraints);

        constraints.gridy = 8;
        constraints.gridwidth = 2;

        create = new JButton("Crear Libro");
        create.setActionCommand("create");
        create.addActionListener(listener);
        add(create,constraints);

    }
}
