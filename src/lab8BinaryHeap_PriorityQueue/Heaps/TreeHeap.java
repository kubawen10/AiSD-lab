package lab8BinaryHeap_PriorityQueue.Heaps;

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

        //could do as one function, time logn + logn -> logn
        addLast(element);
        bubbleUp(traversalOrderToPos(currentlyStored), root);
    }

    private Node bubbleUp(LinkedList<Integer> queue, Node node) {
        Node child = null;
        int dir = -1;

        if (!queue.isEmpty()) {
            dir = queue.removeFirst();

            if (dir == 0) {
                child = bubbleUp(queue, node.left);
                node.left = child;
            } else {
                child = bubbleUp(queue, node.right);
                node.right = child;
            }
        }

        if (child != null && comparator.compare(child.value, node.value) < 0) {
            T temp = node.value;
            node.value = child.value;
            child.value = temp;
        }
        return node;
    }

    private void addLast(T element) {
        if (currentlyStored == 1) {
            root = new Node(element);
        } else {
            Node parent = findParentOfLast();

            if (parent.left == null) {
                parent.left = new Node(element);
            } else {
                parent.right = new Node(element);
            }
        }
    }

    @Override
    public T minimum() {
        if (root == null) return null;

        T minimum = root.value;
        Node parentOfLast = findParentOfLast();


        if (parentOfLast.right != null) {
            root.value = parentOfLast.right.value;
            parentOfLast.right = null;
        } else if (parentOfLast.left != null) {
            root.value = parentOfLast.left.value;
            parentOfLast.left = null;
        }


        currentlyStored--;
        root = sink(root);

        if (currentlyStored == 0) {
            root = null;
        }
        return minimum;
    }

    private Node sink(Node parent) {
        if (parent == null) return null;

        Node tempNode;
        if (parent.left != null && parent.right != null) {
            if (comparator.compare(parent.left.value, parent.right.value) > 0) {
                tempNode = parent.right;
            } else {
                tempNode = parent.left;
            }
        } else if (parent.left == null && parent.right != null) {
            tempNode = parent.right;
        } else if (parent.left != null) {
            tempNode = parent.left;
        } else {
            return parent;
        }

        if (comparator.compare(parent.value, tempNode.value) > 0) {
            T temp = parent.value;
            parent.value = tempNode.value;
            tempNode.value = temp;
            sink(tempNode);
        }

        return parent;
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
            queue.addFirst(pos % 2);
            pos /= 2;
        }

        //0 -> go left
        //1 -> go right

        return queue;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);

        Node n;

        int depth = (int) (Math.log(currentlyStored) / Math.log(2));
        int lowestLevelMaxWidth = ((int) Math.pow(2, depth) * 2 - 1) * 2;
        int space = 2;
        int indent = (lowestLevelMaxWidth - space) / 2;

        int counter = 0;
        int i = 1;

        while (!queue.isEmpty()) {
            n = queue.removeFirst();

            if (n != null) {
                s.append(formatNode(n, indent, space));
                queue.addLast(n.left);
                queue.addLast(n.right);
            }

            counter++;

            if (counter == i) {
                indent = (indent - space) / 2;
                s.append("\n");
                i *= 2;
                counter = 0;
            }
        }

        return s.substring(0, s.length() - 1);
    }

    private String formatNode(Node n, int indent, int space) {
        return nSpaceString(indent) + String.format("%" + space + "s", n.value) + nSpaceString(indent + space);
    }

    private String nSpaceString(int n) {
        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i < n; i++) {
            returnString.append(" ");
        }

        return returnString.toString();
    }
}
