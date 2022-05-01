package lab5_6SortingAlgorithms;

import lab5_6SortingAlgorithms.core.SortingAlgorithm;

import java.util.*;

public class MergeSortArray<T> extends SortingAlgorithm<T> {
    public MergeSortArray(Comparator<? super T> comparator) {
        super(comparator);
    }

    @Override
    public List<T> sort(List<T> list) {
        LinkedList<T[]> queue = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            T[] l = (T[]) (new Object[1]);
            l[0] = list.get(i);

            queue.addLast(l);
        }

        while (queue.size() > 1) {
            T[] l1 = queue.removeFirst();
            T[] l2 = queue.removeFirst();

            queue.addLast(merge(l1, l2));
        }

        if (list.size() == 0) return list;

        list = Arrays.asList(queue.getFirst());

        return list;
    }

    public T[] merge(T[] l1, T[] l2) {
        T[] merged = (T[]) (new Object[l1.length + l2.length]);

        int l1CurIndex = 0;
        int l2CurIndex = 0;
        int curAddIndex = 0;

        while (l1CurIndex < l1.length && l2CurIndex < l2.length) {
            if (compare(l1[l1CurIndex], l2[l2CurIndex]) <= 0) {
                merged[curAddIndex] = l1[l1CurIndex];
                l1CurIndex++;
            } else {
                merged[curAddIndex] = l2[l2CurIndex];
                l2CurIndex++;
            }
            curAddIndex++;
        }

        while (l1CurIndex < l1.length) {
            merged[curAddIndex] = l1[l1CurIndex];
            l1CurIndex++;
            curAddIndex++;
        }

        while (l2CurIndex < l2.length) {
            merged[curAddIndex] = l2[l2CurIndex];
            l2CurIndex++;
            curAddIndex++;
        }

        return merged;
    }
}
