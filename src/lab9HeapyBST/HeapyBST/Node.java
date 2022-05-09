package lab9HeapyBST.HeapyBST;

public class Node <T>{
    private T value;
    private int priority;

    private Node<T> left;
    private Node<T> right;

    public Node(T val){
        value=val;
    }

    public Node(T val, Node<T> l, Node<T> r){
        value = val;
        left = l;
        right = r;


    }

    public String toString(){
        return value.toString();
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
}
