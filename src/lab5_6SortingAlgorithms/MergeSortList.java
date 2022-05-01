package lab5_6SortingAlgorithms;

import lab5_6SortingAlgorithms.core.SortingAlgorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeSortList<T> extends SortingAlgorithm<T> {
    public MergeSortList(Comparator<? super T> comparator) {
        super(comparator);
    }

    @Override
    public List<T> sort(List<T> list) {

        LinkedList<List<T>> queue = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            List<T> l = new ArrayList<>();
            l.add(list.get(i));

            queue.addLast(l);
        }

        while (queue.size() > 1) {
            List<T> l1 = queue.removeFirst();
            List<T> l2 = queue.removeFirst();

            queue.addLast(merge(l1, l2));
        }

        if (list.size()==0) return list;

        list = queue.getFirst();

        return list;
    }

    public List<T> merge(List<T> l1, List<T> l2) {
        List<T> merged = new ArrayList<>();

        while (!l1.isEmpty() && !l2.isEmpty()) {
            if (compare(l1.get(0), l2.get(0)) <= 0) {
                merged.add(l1.remove(0));

            } else {
                merged.add(l2.remove(0));
            }
        }

        while(!l1.isEmpty()){
            merged.add(l1.remove(0));
        }

        while(!l2.isEmpty()){
            merged.add(l2.remove(0));
        }

        return merged;
    }
}
