package tests;

import java.util.List;

public class ShakerSort {
    public ShakerSort(){
    }

    public List<Integer> sort(List<Integer> list) {
        int left = 0;
        int right = list.size()-1;

        int i = left;

        while(left<=right){
            boolean sorted = true;
            System.out.println(list);
            for (int j = i; j < right; j++) {
                if(compare(list.get(j), list.get(j+1))>0){
                    swap(list, j, j+1);
                    sorted = false;
                }
                System.out.println(list + " " + j);
            }


            for (int j = right; j > i; j--) {
                if (compare(list.get(j), list.get(j-1))<0){
                    swap(list, j, j-1);
                    sorted = false;
                }
                System.out.println(list);
            }
            System.out.println();

            if (sorted) return list;

            left++;
            right--;
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
