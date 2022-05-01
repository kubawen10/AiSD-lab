package lab8BinaryHeap_PriorityQueue;

import java.util.Comparator;
import java.util.LinkedList;

public class TreeHeap<T> implements BinaryMinHeap<T> {
    class Node {
        T value;
        Node left;
        Node right;

        Node(T value) {
            this.value = value;
        }
    }

    private Node root;
    private Comparator<T> comparator;
    private int currentlyStored = 0;

    public TreeHeap(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void clear() {
        root = null;
        currentlyStored = 0;
    }

    @Override
    public void add(T element) {
        if (element == null) {
            throw new NullPointerException();
        }

        currentlyStored++;
    }

    @Override
    public T minimum() {
        if (root == null) return null;

        T minimum = root.value;
    }

    private Node findNodeAtPos(int pos) {
        Node curNode = root;
        LinkedList<Integer> queue = traversalOrderToPos(pos);
        int dir;
        while (!queue.isEmpty()) {
            dir = queue.removeFirst();
            if (dir == 0) {
                curNode = curNode.left;
            } else {
                curNode = curNode.right;
            }
        }
        return curNode;
    }

    private Node findLast() {
        return findNodeAtPos(currentlyStored);
    }

    private Node findParentOfLast() {
        return findNodeAtPos(currentlyStored / 2);
    }

    private LinkedList<Integer> traversalOrderToPos(int pos) {
        LinkedList<Integer> queue = new LinkedList<>();

        while (pos > 1) {
            queue.addLast(pos % 2);
            pos /= 2;
        }

        //0 -> go left
        //1 -> go right

        return queue;
    }
}
