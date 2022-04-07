package lab56SortingAlgorithms;

import lab56SortingAlgorithms.core.SortingAlgorithm;

import java.util.Comparator;
import java.util.List;

public class InsertionSort<T> extends SortingAlgorithm<T> {
    public InsertionSort(Comparator<? super T> comparator) {
        super(comparator);
    }

    @Override
    public List<T> sort(List<T> list) {
        int size = list.size();

        for (int i = 1; i < size; i++) {
            int j = i;

            int index = findInsertionIndex(list, i);

            while(j>index){
                swap(list, j, j-1);
                j--;
            }
        }

        return list;
    }

    private int findInsertionIndex(List<T> list, int r) {
        T element = list.get(r);
        int l = 0;
        r = r - 1;
        int m;
        int comparison;

        while (l <= r) {
            m = (l+r) / 2;
            comparison = compare(element, list.get(m));

            if (comparison == 0) {
                return m + 1;
            } else if (comparison > 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return l;
    }
}
