package lab8BinaryHeap_PriorityQueue.Heaps;

public interface BinaryMinHeap<T> {
    void clear();
    void add(T element);
    T minimum();
}
