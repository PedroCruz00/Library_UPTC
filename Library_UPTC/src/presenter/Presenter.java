package presenter;

import model.Autor;
import model.Book;
import model.Library;
import view.Dashboard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Presenter implements ActionListener {

    private Dashboard dashboard;
    private Library library;

    public Presenter() {
        library = new Library();
        dashboard = new Dashboard(this);
    }

    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Presenter();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comand = e.getActionCommand();
        if(comand.equals("create")){
            String title = dashboard.getCreateBook().getInputTitle().getText();
            String isbn = dashboard.getCreateBook().getInputISBN().getText();
            String nameAutor = dashboard.getCreateBook().getInputNameAutor().getText();
            String lastNameAutor = dashboard.getCreateBook().getInputLastNameAutor().getText();
            String biography = dashboard.getCreateBook().getInputBiographyAutor().getText();
            int volume = Integer.parseInt(dashboard.getCreateBook().getInputVolume().getText());
            int quantity =Integer.parseInt(dashboard.getCreateBook().getInputQuantity().getText());
            String editorial = dashboard.getCreateBook().getInputEditorial().getText();
            String  campus = dashboard.getCreateBook().getCampus().toString();
            String subCampus = dashboard.getCreateBook().getLibrary().toString();
            Book book = new Book(isbn,title,volume,editorial,campus,subCampus, new Autor(nameAutor,lastNameAutor,biography),quantity);
            library.addBook(book);
            dashboard.getListBooks().setData(library.listAllBooks());
            dashboard.getListBooks().repaint();
        }

    }
}