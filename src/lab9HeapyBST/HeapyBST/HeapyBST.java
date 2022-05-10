package lab9HeapyBST.HeapyBST;

import lab9HeapyBST.Core.BSTInterface;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class HeapyBST<T> implements BSTInterface<T> {
    private final Comparator<T> comparator;
    private Node<T> root;

    public HeapyBST(Comparator<T> valueComparator) {
        comparator = valueComparator;
        root = null;
    }


    public void clear(){
        root = null;
    }

    //finding
    public T find(T value) {
        Node<T> node = searchNode(value);

        return node == null ? null : node.getValue();
    }

    private Node<T> searchNode(T value) {
        Node<T> curNode = root;
        int comparison;

        while (curNode != null && (comparison = comparator.compare(value, curNode.getValue())) != 0) {
            curNode = comparison < 0 ? curNode.getLeft() : curNode.getRight();
        }

        return curNode;
    }


    //inserting
    public void insert(T value) {
        if(value==null){
            throw new NullPointerException();
        }

        root = insertWithSwap(root, value);
    }

    private Node<T> insertWithSwap(Node<T> n, T value) {
        if (n == null) {
            return new Node<>(value);
        }

        int cmp = comparator.compare(value, n.getValue());

        if (cmp < 0) {
            n.setLeft(insertWithSwap(n.getLeft(), value));

            if (n.comparePriorities(n.getLeft()) < 0) {
                return rotateRight(n.getLeft(), n);
            }
        } else if (cmp > 0) {
            n.setRight(insertWithSwap(n.getRight(), value));

            if (n.comparePriorities(n.getRight()) < 0) {
                return rotateLeft(n, n.getRight());
            }
        } else {
            throw new UnsupportedOperationException();
        }

        return n;
    }

    private Node<T> rotateRight(Node<T> l, Node<T> r) {
        r.setLeft(l.getRight());
        l.setRight(r);

        return l;
    }

    private Node<T> rotateLeft(Node<T> l, Node<T> r) {
        l.setRight(r.getLeft());
        r.setLeft(l);

        return r;
    }


    //deleting
    public void delete(T value) {
        root = delete(root, value);
    }

    private Node<T> delete(Node<T> n, T value) {
        if (n == null) {
            throw new NoSuchElementException();
        }

        int cmp = comparator.compare(n.getValue(), value);

        if (cmp > 0) {//go left
            n.setLeft(delete(n.getLeft(), value));
        } else if (cmp < 0) {//go right
            n.setRight(delete(n.getRight(), value));
        } else {//equal
            //n is a leaf, delete it by returning null
            if (n.getLeft() == null && n.getRight() == null) {
                return null;
            }
            //left isnt null and right is (by rotating right n will be a leaf)
            else if(n.getLeft()!=null && n.getRight()==null){
                return delete(rotateRight(n.getLeft(), n), value);
            }else{//left is null and right isnt or both arent nulls
                return delete(rotateLeft(n, n.getRight()), value);
            }
        }

        return n;
    }

    //printing
    public String printLevels() {
        LinkedList<Node<T>> queue = new LinkedList<>();
        StringBuilder s = new StringBuilder();


        queue.addLast(root);
        Node<T> n;

        int it = 0;
        int pow = 1;

        while (!isNulls(queue)) {
            it++;
            n = queue.removeFirst();
            if (n != null) {
                s.append(n).append(" ");
                queue.addLast(n.getLeft());
                queue.addLast(n.getRight());
            } else {
                s.append("null").append(" ");
                queue.addLast(null);
                queue.addLast(null);
            }

            if (it == pow) {
                pow *= 2;
                it = 0;
                s.append("\n");
            }
        }
        return s.toString();
    }

    private boolean isNulls(LinkedList<Node<T>> q) {
        for (Node<T> tNode : q) {
            if (tNode != null) {
                return false;
            }
        }
        return true;
    }

    public String preOrderWalk() {
        String s = preOrderWalk(root);
        return s.substring(0, s.length() - 1);
    }

    public String inOrderWalk() {
        String s = inOrderWalk(root);
        return s.substring(0, s.length() - 1);
    }

    public String postOrderWalk() {
        String s = postOrderWalk(root);
        return s.substring(0, s.length() - 1);
    }

    private String preOrderWalk(Node<T> n) {
        String s = "";
        if (n != null) {
            s += n + " ";
            s += preOrderWalk(n.getLeft());
            s += preOrderWalk(n.getRight());
        }
        return s;
    }

    private String inOrderWalk(Node<T> n) {
        String s = "";
        if (n != null) {
            s += inOrderWalk(n.getLeft());
            s += n + " ";
            s += inOrderWalk(n.getRight());
        }
        return s;
    }

    private String postOrderWalk(Node<T> n) {
        String s = "";
        if (n != null) {
            s += postOrderWalk(n.getLeft());
            s += postOrderWalk(n.getRight());
            s += n + " ";
        }
        return s;
    }

}

