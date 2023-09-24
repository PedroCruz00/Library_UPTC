package view;

import view.menu.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {
    private Toolkit toolkit;
    private Dimension dimension;
    private CreateBook createBook;
    private DeleteBook deleteBook;
    private SearchBook searchBook;
    private ListBooks listBooks;
    private MainMenu mainMenu;
    public Dashboard(ActionListener listener){
        toolkit = Toolkit.getDefaultToolkit();
        dimension = toolkit.getScreenSize();
        initPanels(listener);
        setSize(dimension);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void initPanels(ActionListener listener){
        mainMenu = new MainMenu(this);
        setJMenuBar(mainMenu);
        createBook = new CreateBook(listener);
        getContentPane().add(createBook);

        deleteBook = new DeleteBook(listener);
        searchBook = new SearchBook(listener);
        listBooks = new ListBooks();

    }
    public void visibleDeleteMenu(){
        getContentPane().add(deleteBook);
        deleteBook.setVisible(true);
        searchBook.setVisible(false);
        listBooks.setVisible(false);
        createBook.setVisible(false);
    }
    public void visibleSearchMenu(){
        getContentPane().add(searchBook);
        searchBook.setVisible(true);
        createBook.setVisible(false);
        deleteBook.setVisible(false);
        listBooks.setVisible(false);

    } public void visibleListMenu(){
        getContentPane().add(listBooks);
        listBooks.setVisible(true);
        createBook.setVisible(false);
        deleteBook.setVisible(false);
        searchBook.setVisible(false);

    }
    public void visibleCreateMenu(){
        createBook.setVisible(true);
        listBooks.setVisible(false);
        deleteBook.setVisible(false);
        searchBook.setVisible(false);
    }

    public CreateBook getCreateBook() {
        return createBook;
    }

    public ListBooks getListBooks() {
        return listBooks;
    }
}
