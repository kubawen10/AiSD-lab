package tests;

import java.util.List;

public class InsertionSort {

    public InsertionSort(){}

    public List<Integer> sort(List<Integer> list) {
        int size = list.size();

        for (int i = 1; i < size; i++) {
            int j = i;


            int index = findInsertionIndex(list, i);

            while(j>index){
                System.out.println(list);
                swap(list, j, j-1);
                j--;
            }
            System.out.println(list);
            System.out.println();
        }

        return list;
    }

    private int findInsertionIndex(List<Integer> list, int r) {
        Integer element = list.get(r);
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

    public int compare(int x, int y) {
        return Integer.compare(x, y);
    }

    public void swap(List<Integer> list, int index1, int index2) {
        int temp = list.get(index1);

        list.set(index1, list.get(index2));
        list.set(index2, temp);

    }
}
