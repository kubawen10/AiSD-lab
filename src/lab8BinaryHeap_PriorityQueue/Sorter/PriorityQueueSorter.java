package lab8BinaryHeap_PriorityQueue.Sorter;

import lab8BinaryHeap_PriorityQueue.Heaps.BinaryMinHeap;

import java.util.List;

public class PriorityQueueSorter<T> {
    private final BinaryMinHeap<T> binaryMinHeap;

    public PriorityQueueSorter(BinaryMinHeap<T> binaryMinHeap) {
        this.binaryMinHeap = binaryMinHeap;
    }

    public List<T> sort(List<T> list) {
        binaryMinHeap.clear();

        for (int i = 0; i < list.size(); i++) {
            binaryMinHeap.add(list.get(i));
        }

        for (int i = 0; i < list.size(); i++) {
            list.set(i, binaryMinHeap.minimum());
        }

        //System.out.println(list);
        return list;
    }
}
