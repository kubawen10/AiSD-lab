package lab5_6SortingAlgorithms;

import lab5_6SortingAlgorithms.core.SortingAlgorithm;

import java.util.*;

public class QuickSort<T> extends SortingAlgorithm<T> {
    private boolean random;
    private final Random r = new Random();
    private Comparator<? super T> comparator;
    public QuickSort(Comparator<? super T> comparator, boolean randomIndex) {
        super(comparator);
        this.comparator=comparator;
        this.random = randomIndex;
    }

    @Override
    public List<T> sort(List<T> list) {
        if(list.size()<=1){
            return list;
        }

        List<T> smaller = new LinkedList<>();
        List<T> greater = new LinkedList<>();


        //int pivot = pivotIndex(list.size());   //lab
        int pivot = pivotIndexCw(list);         //cw
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
        return random ? r.nextInt(size) : 0;
    }

    public int pivotIndexCw(List<T> list){
        if(list.size()<=100){
            return pivotIndex(list.size());
        }

        int i1 = r.nextInt(list.size());
        int i2 = r.nextInt(list.size());
        int i3 = r.nextInt(list.size());

        T val1 = list.get(i1);
        T val2 = list.get(i2);
        T val3 = list.get(i3);

        if((comparator.compare(val1, val2)<0 && comparator.compare(val2,val3)<0) ||
                (comparator.compare(val1, val2)>0 && comparator.compare(val2,val3)>0)) return i2;

        else if((comparator.compare(val1, val3)<0 && comparator.compare(val3,val2)<0) ||
                (comparator.compare(val1, val3)>0 && comparator.compare(val3,val2)>0)) return i3;

        else return i1;
    }

}
