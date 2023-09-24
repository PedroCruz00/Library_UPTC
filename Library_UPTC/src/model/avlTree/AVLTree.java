package model.avlTree;


import java.util.*;

public final class AVLTree<T extends Comparable<? super T>>extends AbstractCollection<T>{

    private final Comparator<? super T> comparator;
    private Node<T> root;
    private int size;

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    private AVLTree(Comparator<? super T> comparator) {
        this.size = 0;
        this.comparator = Objects.requireNonNull(comparator, "comparator can't be null");
    }


    public static <T extends Comparable<? super T>> AVLTree<T> of() {
        return new AVLTree<>(Comparator.naturalOrder());
    }

    public static <T extends Comparable<? super T>> AVLTree<T> of(Comparator<? super T> comparator) {
        return new AVLTree<T>(comparator);
    }


    public static <T extends Comparable<? super T>> AVLTree<T> of(Iterable<T> elements) {
        Comparator<? super T> comparator = elements instanceof SortedSet
                ? ((SortedSet<T>) elements).comparator()
                : Comparator.naturalOrder();
        return of(comparator, elements);
    }

    public void displayTree() {
        displayTree(root, 0);
    }


    private void displayTree(Node<T> node, int level) {
        if (node != null) {
            displayTree(node.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(node.key);
            displayTree(node.left, level + 1);
        }
    }

    @SafeVarargs
    public static <T extends Comparable<? super T>> AVLTree<T> of(T... elements) {
        return of(Comparator.naturalOrder(), elements);
    }


    @SafeVarargs
    public static <T extends Comparable<? super T>> AVLTree<T> of(Comparator<? super T> comparator,
                                                                  T... elements) {
        AVLTree<T> set = new AVLTree<T>(comparator);
        Collections.addAll(set, elements);
        return set;
    }

    public static <T extends Comparable<? super T>> AVLTree<T> of(Comparator<? super T> comparator,Iterable<T> elements) {
        AVLTree<T> set = new AVLTree<T>(comparator);
        for (T element : elements) {
            set.add(element);
        }
        return set;
    }


    @Override
    public boolean add(T e) {
        return insert(e);
    }

    @Override
    public boolean contains(Object o) {
        return find(o) != null;
    }

    @Override
    public boolean remove(Object o) {
        Node<T> k = find(o);
        if (k != null) {
            delete(k);
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }


    @Override
    public boolean removeAll(Collection<?> c) {
        boolean mod = false;
        for (Object o : c) {
            Node<T> n = find(o);
            if (n != null) {
                delete(n);
                mod = true;
            }
        }
        return mod;
    }



    private static <T extends Comparable<? super T>> int balance(Node<T> node) {
        return (node.right != null ? node.right.height : 0)
                - (node.left != null ? node.left.height : 0);
    }

    private static <T extends Comparable<? super T>> Node<T> removeChildGetNextNonLeaf(Node<T> parent, Node<T> child) {
        if (child == parent.left) {
            parent.left = null;
            if (parent.right == null) {
                parent.height = 1;
                return parent.parent;
            }
        } else {
            parent.right = null;
            if (parent.left == null) {
                parent.height = 1;
                return parent.parent;
            }
        }
        return parent;
    }

    private static <T extends Comparable<? super T>> void swapLinksRight(Node<T> x, Node<T> y) {
        x.left = y.right;
        if (x.left != null) {
            x.left.parent = x;
        }
        x.parent = y;
        y.right = x;
    }

    private static <T extends Comparable<? super T>> void swapLinksLeft(Node<T> x, Node<T> y) {
        x.right = y.left;
        if (x.right != null) {
            x.right.parent = x;
        }
        x.parent = y;
        y.left = x;
    }


    private void swapSubTreeRoot(Node<T> oldNode, Node<T> newNode) {
        Node<T> parent = oldNode.parent;
        newNode.parent = parent;
        if (parent != null) {
            if (parent.right == oldNode) {
                parent.right = newNode;
            } else {
                parent.left = newNode;
            }
        } else {
            root = newNode;
        }
    }

    private void turnRightOnInsert(Node<T> A) {
        A.height--;
        Node<T> B = A.left;
        if (balance(B) == 1) {
            Node<T> C = B.right;
            C.height = B.height--;
            swapSubTreeRoot(A, C);
            swapLinksLeft(B, C);
            swapLinksRight(A, C);
        } else {
            swapSubTreeRoot(A, B);
            swapLinksRight(A, B);
        }
    }

    private void turnLeftOnInsert(Node<T> A) {
        A.height--;
        Node<T> B = A.right;
        if (balance(B) == -1) {
            Node<T> C = B.left;
            C.height = B.height--;
            swapSubTreeRoot(A, C);
            swapLinksRight(B, C);
            swapLinksLeft(A, C);
        } else {
            swapSubTreeRoot(A, B);
            swapLinksLeft(A, B);
        }
    }

    private Node<T> turnRightOnDelete(Node<T> A) {
        Node<T> B = A.left;
        switch (balance(B)) {
            case 1:
                A.height -= 2;
                Node<T> C = B.right;
                C.height = B.height--;
                swapSubTreeRoot(A, C);
                swapLinksLeft(B, C);
                swapLinksRight(A, C);
                return C.parent;
            case -1:
                A.height -= 2;
                swapSubTreeRoot(A, B);
                swapLinksRight(A, B);
                return B.parent;
            case 0:
                A.height--;
                B.height++;
                swapSubTreeRoot(A, B);
                swapLinksRight(A, B);
                return null;
        }
        return null;
    }

    private Node<T> turnLeftOnDelete(Node<T> A) {
        Node<T> B = A.right;
        switch (balance(B)) {
            case -1:
                A.height -= 2;
                Node<T> C = B.left;
                C.height = B.height--;
                swapSubTreeRoot(A, C);
                swapLinksRight(B, C);
                swapLinksLeft(A, C);
                return C.parent;
            case 1:
                A.height -= 2;
                swapSubTreeRoot(A, B);
                swapLinksLeft(A, B);
                return B.parent;
            case 0:
                A.height--;
                B.height++;
                swapSubTreeRoot(A, B);
                swapLinksLeft(A, B);
                return null;
        }
        return null;
    }

    private void balanceAfterInsert(Node<T> node) {
        while (node != null) {
            switch (balance(node)) {
                case -2:
                    turnRightOnInsert(node);
                    return;
                case 0:
                    return;
                case 2:
                    turnLeftOnInsert(node);
                    return;
                default:
                    node.height++;
                    node = node.parent;
            }
        }
    }

    private void balanceAfterDelete(Node<T> node) {
        while (node != null) {
            switch (balance(node)) {
                case -2:
                    node = turnRightOnDelete(node);
                    break;
                case 0:
                    node.height--;
                    node = node.parent;
                    break;
                case 2:
                    node = turnLeftOnDelete(node);
                    break;
                default:
                    return;
            }
        }
    }


    public Node<T> find(Object key) {
        @SuppressWarnings("unchecked")
        T k = (T) key;
        Comparator<? super T> cpr = comparator;
        Node<T> node = root;
        while (node != null) {
            int cmp = cpr.compare(k, node.key);
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }

    private boolean insert(T key) {
        Node<T> node = root;

        if (node != null) {
            Comparator<? super T> cpr = comparator;
            Node<T> last;
            int cmp;
            do {
                cmp = cpr.compare(key, node.key);
                if (cmp < 0) {
                    node = (last = node).left;
                } else if (cmp > 0) {
                    node = (last = node).right;
                } else {
                    return false;
                }
            } while (node != null);

            Node<T> newNode = new Node<>(key);
            newNode.parent = last;

            if (cmp > 0) {
                last.right = newNode;
            } else {
                last.left = newNode;
            }

            if (last.height == 1) {
                last.height = 2;
                balanceAfterInsert(last.parent);
            }

        } else {
            root = new Node<>(key);
        }

        size++;
        return true;
    }

    private void delete(Node<T> r) {
        Node<T> rp = r.parent;
        Node<T> rl = r.left;
        Node<T> rr = r.right;

        if (rl == null && rr == null) {
            if (rp != null) {
                rp = removeChildGetNextNonLeaf(rp, r);
            } else {
                root = null;
            }

        } else if (rl == null || rr == null) {
            swapSubTreeRoot(r, (rl == null ? rr : rl));

        } else {
            while (rl.right != null) {
                rl = rl.right;
            }
            r.key = rl.key;
            rp = rl.parent;
            if (rl.left != null) {
                swapSubTreeRoot(rl, rl.left);
            } else {
                rp = removeChildGetNextNonLeaf(rp, rl);
            }
        }

        balanceAfterDelete(rp);
        size--;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

}