package lab9HeapyBST.HeapyBST;

import java.util.Random;

public class Node<T> {
    private final int MAX_PRIORITY = 1000;

    private T value;
    private int priority;

    private Node<T> left;
    private Node<T> right;

    public Node(T val) {
        value = val;
        priority = generatePriority();
    }

    public Node(T val,int priority) {
        value = val;
        this.priority=priority;
    }

    public String toString() {
        return "{" + value.toString() + " " + priority +"}";
    }

    public int generatePriority() {
        Random random = new Random();
        return random.nextInt(MAX_PRIORITY);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int comparePriorities(Node<T> other) {
        if (priority - other.getPriority() >= 0) {
            return 1;
        } else return -1;
    }
}
