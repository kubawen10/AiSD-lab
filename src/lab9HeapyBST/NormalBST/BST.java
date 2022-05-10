package lab9HeapyBST.NormalBST;

import lab9HeapyBST.Core.BSTInterface;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class BST<T> implements BSTInterface<T> {
    private final Comparator<T> comparator;
    private Node<T> root;

    public BST(Comparator<T> comparator) {
        this.comparator = comparator;
        root = null;
    }

    @Override
    public void clear(){
        root = null;
    }

    public T find(T value) {
        Node<T> n = search(value);
        return n == null ? null : n.getValue();
    }

    private Node<T> search(T value) {
        Node<T> n = root;
        int cmp;

        while (n != null && (cmp = comparator.compare(value, n.getValue())) != 0) {
            n = cmp < 0 ? n.getLeft() : n.getRight();
        }
        return n;
    }

    public void insert(T elem) {
        if (root == null) {
            root = new Node<>(elem);
            return;
        }

        Node<T> n = root;
        int cmp;
        Node<T> goTo;

        do {
            cmp = comparator.compare(elem, n.getValue());
            if (cmp < 0) {
                goTo = n.getLeft();
            } else if (cmp > 0) {
                goTo = n.getRight();
            } else {
                throw new UnsupportedOperationException();
            }
            if (goTo != null) {
                n = goTo;
            }
        }
        while (goTo != null);

        if (cmp < 0) {
            n.setLeft(new Node<>(elem));
        } else {
            n.setRight(new Node<>(elem));
        }
    }

    public void delete(T elem){
        Node<T> x;
        Node<T> y;
        Node<T> z = search(elem);

        if(z.getRight()==null || z.getLeft()==null){
            y=z;
        }else{
            y=getSuccessorNode(z);
        }

        if(y.getLeft()!=null){
            x=y.getLeft();
        }else{
            x=y.getRight();
        }

        if (x!=null){
            x.setParent(y.getParent());
        }

        if(y.getParent()==null){
            root = x;
        }else if(y==y.getParent().getLeft()){
            y.getParent().setLeft(x);
        }else{
            y.getParent().setRight(x);
        }

        if(y!=z){
            T temp = y.getValue();
            y.setValue(z.getValue());
            z.setValue(temp);
        }
    }

    public T getSuccessor(T value) {
        Node<T> startNode = search(value);

        if (startNode == null) {
            throw new NoSuchElementException();
        }

        Node<T> successor = getSuccessorNode(startNode);
        if (successor == null) {
            return null;
        }

        return successor.getValue();
    }

    private Node<T> getSuccessorNode(Node<T> node) {
        if (node.getRight() != null) {
            return getMinNode(node.getRight());
        }
        Node<T> parent = node.getParent();
        while (parent != null && node == parent.getRight()) {
            node = parent;
            parent = node.getParent();
        }
        return parent;
    }

    public T getMin() {
        if (root == null) {
            throw new NoSuchElementException();
        }
        return getMinNode(root).getValue();
    }

    public T getMax() {
        if (root == null) {
            throw new NoSuchElementException();
        }
        return getMaxNode(root).getValue();
    }

    private Node<T> getMinNode(Node<T> n) {
        while (n.getLeft() != null) {
            n = n.getLeft();
        }
        return n;
    }

    private Node<T> getMaxNode(Node<T> n) {
        while (n.getRight() != null) {
            n = n.getRight();
        }
        return n;
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

    public String printLevels() {
        StringBuilder s = new StringBuilder();
        LinkedList<Node<T>> queue = new LinkedList<>();
        queue.addLast(root);
        Node<T> n;

        while (!queue.isEmpty()) {
            n = queue.removeFirst();
            if (n != null) {
                s.append(n).append(" ");
                queue.addLast(n.getLeft());
                queue.addLast(n.getRight());
            }
        }

        if (s.length()>0){
            return s.substring(0, s.length()-1);
        }
        return s.toString();
    }

    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(Node n) {
        if (n == null) {
            return 0;
        }

        return 1 + countNodes(n.getLeft()) + countNodes(n.getRight());
    }

    public int height() {
        return height(root);
    }

    private int height(Node n) {
        if (n == null) {
            return 0;
        }

        int leftH = height(n.getLeft());
        int rightH = height(n.getRight());

        return 1 + (Math.max(leftH, rightH));
    }

    public int evenKeyNodes() {
        return evenKeyNodes(root);
    }

    private int evenKeyNodes(Node<T> n) {
        if (n == null) {
            return 0;
        }

        int sum = 0;

        if (isEven(n.getValue())) {
            sum = 1;
        }

        return sum + evenKeyNodes(n.getLeft()) + evenKeyNodes(n.getRight());
    }

    private boolean isEven(T val){
        if(val instanceof Integer){
            return (Integer) val % 2 == 0;
        }
        return false;
    }

    public int countOneChildNodes() {
        return countOneChildNodes(root);
    }

    private int countOneChildNodes(Node n) {
        if (n == null) {
            return 0;
        }

        int sum = 0;

        if ((n.getRight() == null && n.getLeft() != null) || (n.getLeft() == null && n.getRight() != null)) {
            sum = 1;
        }

        sum += countOneChildNodes(n.getRight()) + countOneChildNodes(n.getLeft());

        return sum;
    }

    public int countOneBroNodes() {
        return countOneBroNodes(root);
    }

    private int countOneBroNodes(Node n) {
        if (n == null) {
            return 0;
        }

        int sum = 0;

        if (n.getRight() != null && n.getLeft() != null) {
            sum = 2;
        }

        sum += countOneBroNodes(n.getRight()) + countOneBroNodes(n.getLeft());

        return sum;
    }
}
