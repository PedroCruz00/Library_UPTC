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
        Book searchBook = new Book(codeISBN, "", 0, "", null, null, 0);
        Node<Book> resultNode = libraryTree.find(searchBook);
        return resultNode != null ? resultNode.getKey() : null;
    }

    public boolean containsBook(Book book) {
        return libraryTree.contains(book);
    }

    public int getLibrarySize() {
        return libraryTree.size();
    }


    public List<Book> listAllBooks() {
        List<Book> bookList = new ArrayList<>();
        inOrderTraversal(libraryTree.getRoot(), bookList);
        return bookList;
    }

    private void inOrderTraversal(Node<Book> node, List<Book> bookList) {
        if (node != null) {
            inOrderTraversal(node.getLeft(), bookList);
            bookList.add(node.getKey());
            inOrderTraversal(node.getRight(), bookList);
        }
    }
}



