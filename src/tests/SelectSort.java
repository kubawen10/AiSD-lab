package tests;

import java.util.List;

public class SelectSort {
    public SelectSort() {
    }

    public List<Integer> sort(List<Integer> list) {
        int left = 0;
        int right = list.size()-1;

        int min=0;
        int max=0;

        while (left<=right){
            System.out.println(list);
            for (int i = left; i <= right; i++) {
                System.out.println();
                System.out.println("min element " + list.get(min));
                System.out.println("max element " + list.get(max));
                System.out.println("current element " + list.get(i));
                if (compare(list.get(i), list.get(max))>0){
                    max=i;
                }
                if (compare(list.get(i), list.get(min))<0){
                    min=i;
                }
                System.out.println("after comparisons: ");
                System.out.println("min element " + list.get(min));
                System.out.println("max element " + list.get(max));
            }

            if (max==left){
                max=min;
            }

            swap(list, left, min);
            swap(list, right, max);
            left++;
            right--;

            min=left;
            max=right;
        }

        return list;
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
