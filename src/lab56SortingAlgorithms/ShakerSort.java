package lab56SortingAlgorithms;

import lab56SortingAlgorithms.core.SortingAlgorithm;

import java.util.Comparator;
import java.util.List;

public class ShakerSort<T> extends SortingAlgorithm<T> {
    public ShakerSort(Comparator<? super T> comparator) {
        super(comparator);
    }

    @Override
    public List<T> sort(List<T> list) {
        int left = 0;
        int right = list.size()-1;

        int i = left;

        while(left<=right){
            boolean sorted = true;

            for (int j = i; j < right; j++) {
                if(compare(list.get(j), list.get(j+1))>0){
                    swap(list, j, j+1);
                    sorted = false;
                }
            }

            for (int j = right-1; j > i; j--) {
                if (compare(list.get(j), list.get(j-1))<0){
                    swap(list, j, j-1);
                    sorted = false;
                }
            }


            //if (sorted) return list;

            left++;
            right--;
        }

        return list;
    }
}
