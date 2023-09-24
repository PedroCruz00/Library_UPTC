package view.menu;

import view.myComponents.ButtonDefault;

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
    private JLabel selectLibrary;
    private JComboBox library;
    private JLabel selectCampus;
    private JComboBox campus;
    private JLabel nameAutor;
    private JTextField inputNameAutor;
    private JLabel lastNameAutor;
    private JTextField inputLastNameAutor;
    private JLabel biographyAutor;
    private JTextField inputBiographyAutor;
    private ButtonDefault create;

    public CreateBook(ActionListener listener) {
        setBackground(new Color(241, 239, 239));
        initComponents(listener);
    }

    public void initComponents(ActionListener listener){
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10,10,10,10);
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

        constraints.gridx = 0;
        constraints.gridy = 6;
        selectCampus = new JLabel("Seleccione la sede");
        add(selectCampus,constraints);
        constraints.gridx = 1;
        campus = new JComboBox();
        add(campus,constraints);

        constraints.gridx = 0;
        constraints.gridy = 7;
        selectLibrary = new JLabel("Seleccione el Campues");
        add(selectLibrary,constraints);
        constraints.gridx = 1;
        library = new JComboBox();
        add(library,constraints);

        constraints.gridy = 8;
        constraints.gridwidth = 2;

        create = new ButtonDefault("Crear Libro");
        create.setActionCommand("create");
        create.addActionListener(listener);
        add(create,constraints);

    }
}
