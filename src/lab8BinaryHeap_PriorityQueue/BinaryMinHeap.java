package lab8BinaryHeap_PriorityQueue;

public interface BinaryMinHeap<T> {
    void clear();
    void add(T element);
    T minimum();
}
