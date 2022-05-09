package lab9HeapyBST.NormalBST;

public class Node <T>{
    private T value;
    private Node<T> parent;
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

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
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
        if(left!=null){
            left.setParent(this);
        }
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        if(right!=null){
            right.setParent(this);
        }
        this.right = right;
    }
}
