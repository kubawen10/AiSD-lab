package lab56SortingAlgorithms;

import lab56SortingAlgorithms.core.SortingAlgorithm;

import java.util.*;

public class QuickSort<T> extends SortingAlgorithm<T> {
    private boolean random;

    public QuickSort(Comparator<? super T> comparator, boolean randomIndex) {
        super(comparator);
        this.random = randomIndex;
    }

    @Override
    public List<T> sort(List<T> list) {
        if(list.size()<=1){
            return list;
        }

        List<T> smaller = new LinkedList<>();
        List<T> greater = new LinkedList<>();


        int pivot = pivotIndex(list.size());
        T pivotValue = list.get(pivot);

        Iterator<T> it = list.iterator();
        int i = 0;

        while (it.hasNext()) {
            T val = it.next();

            if(i==pivot){
                i++;
                continue;
            }

            if (compare(val, pivotValue) <= 0){
                smaller.add(val);
            }else {
                greater.add(val);
            }
            i++;
        }

        List<T> l = new LinkedList<>();

        l.addAll(sort(smaller));
        l.add(pivotValue);
        l.addAll(sort(greater));

        return l;
    }

    public int pivotIndex(int size) {
        Random r = new Random();
        return random ? r.nextInt(size) : 0;
    }

}
