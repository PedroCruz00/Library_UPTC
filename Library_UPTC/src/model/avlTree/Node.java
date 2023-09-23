package model.avlTree;


public class Node<T> {
    Node<T> parent;
    Node<T> left;
    Node<T> right;
    T key;
    byte height = 1;

    Node(T key) {
        this.key = key;
    }
}
