package lab8BinaryHeap_PriorityQueue;

import java.util.Comparator;

public class ArrayHeap<T> implements BinaryMinHeap<T> {
    private T[] heap;
    private int initialCapacity;
    private Comparator<T> comparator;

    private int currentlyStored = 0;

    public ArrayHeap(int initialCapacity, Comparator<T> comparator) {
        this.initialCapacity = initialCapacity;
        clear();

        this.comparator = comparator;
    }

    @Override
    public void clear() {
        heap = (T[]) new Object[initialCapacity];
        currentlyStored = 0;
    }

    @Override
    public void add(T element) {
        if (element == null) {
            throw new NullPointerException();
        }

        if (heap[heap.length - 1] != null) {
            enlarge();
        }


        heap[currentlyStored] = element;
        bubbleUp(currentlyStored);

        currentlyStored++;
    }

    private void enlarge() {
        T[] newHeap = (T[]) new Object[heap.length * 2];

        for (int i = 0; i < currentlyStored; i++) {
            newHeap[i] = heap[i];
        }

        heap = newHeap;
    }

    @Override
    public T minimum() {
        if (currentlyStored == 0) {
            return null;
        }

        swap(0, currentlyStored - 1);
        T minimum = heap[currentlyStored - 1];
        heap[currentlyStored - 1] = null;
        currentlyStored--;


        sink(0);

        return minimum;
    }

    private void sink(int index) {
        int swapChildIndex = leftChildIndex(index);

        if (swapChildIndex < currentlyStored) {
            if ((rightChildIndex(index) < currentlyStored) && (comparator.compare(heap[leftChildIndex(index)], heap[rightChildIndex(index)]) > 0)) {
                swapChildIndex++;
            }

            if (comparator.compare(heap[index], heap[swapChildIndex]) > 0) {
                swap(swapChildIndex, index);
                sink(swapChildIndex);
            }
        }
    }

    private void bubbleUp(int index) {
        while (index > 0 && comparator.compare(heap[index], heap[parentIndex(index)]) < 0) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    private void swap(int index1, int index2) {
        if (index1 == index2) return;

        T temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    private int parentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    public int leftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int rightChildIndex(int parentIndex) {
        return leftChildIndex(parentIndex) + 1;
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder("");
        for (int i = 1; i <= currentlyStored; i *= 2) {
            for (int j = i - 1; j < i - 1 + i && j < currentlyStored; j++) {
                returnString.append(heap[j]).append(" ");
            }
            if (i * 2 <= currentlyStored) {
                returnString.append("\n");
            }
        }

        return returnString.toString();
    }
}
