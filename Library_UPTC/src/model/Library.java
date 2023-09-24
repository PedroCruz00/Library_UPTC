package model;

import model.avlTree.AVLTree;
import model.avlTree.Node;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private AVLTree<Book> libraryTree;
    public Library() {
        libraryTree = AVLTree.of();
    }

    public void addBook(Book book) {
        libraryTree.add(book);
    }

    public void removeBook(Book book) {
        if (libraryTree.contains(book)) {
            book.reduceQuantity();
            if (book.getQuantity() == 0) {
                libraryTree.remove(book);
            }
        }
    }

    public Book findBookByISBN(String codeISBN) {
        Book searchBook = new Book();
        searchBook.setCodeISBN(codeISBN);
        Node<Book> resultNode = libraryTree.find(searchBook);
        return resultNode != null ? resultNode.getKey() : null;
    }


    public boolean containsBook(Book book) {
        return libraryTree.contains(book);
    }

    public int getLibrarySize() {
        return libraryTree.size();
    }


    public Object[][]  listAllBooks() {
        List<Book> bookList = new ArrayList<>();
        inOrderTraversal(libraryTree.getRoot(), bookList);
        int numRows = bookList.size();
        int numCols = 8;

        if (bookList == null) {
            return new Object[][]{};
        }
        Object[][] result = new Object[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            Book book = bookList.get(i);
            result[i][0] = book.getCodeISBN();
            result[i][1] = book.getTitle();
            result[i][2] = book.getVolume();
            result[i][3] = book.getEditorial();
            result[i][4] = book.getCampus();
            result[i][5] = book.getSubCampus();
            result[i][6] = book.getInfoAutor();
            result[i][7] = book.getQuantity();
        }
        return result;
    }

    private void inOrderTraversal(Node<Book> node, List<Book> bookList) {
        if (node != null) {
            inOrderTraversal(node.getLeft(), bookList);
            bookList.add(node.getKey());
            inOrderTraversal(node.getRight(), bookList);
        }
    }
}


