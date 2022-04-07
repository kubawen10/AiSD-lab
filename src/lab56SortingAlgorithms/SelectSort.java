package lab56SortingAlgorithms;

import lab56SortingAlgorithms.core.SortingAlgorithm;

import java.util.Comparator;
import java.util.List;

public class SelectSort<T> extends SortingAlgorithm<T> {

    public SelectSort(Comparator<? super T> comparator) {
        super(comparator);
    }

    @Override
    public List<T> sort(List<T> list) {
        int left = 0;
        int right = list.size() - 1;

        int min = 0;
        int max = 0;

        while (left <= right) {
            for (int i = left; i <= right; i++) {
                if (compare(list.get(i), list.get(max)) > 0) {
                    max = i;
                }
                if (compare(list.get(i), list.get(min)) < 0) {
                    min = i;
                }
            }

            //warunek bo po swap indeks left znajdzie sie w miejscu min
            if (max == left) {
                max = min;
            }

            swap(list, left, min);
            swap(list, right, max);
            left++;
            right--;

            min = left;
            max = right;
        }

        return list;
    }
}

