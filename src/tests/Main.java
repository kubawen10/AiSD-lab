package tests;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InsertionSort s = new InsertionSort();

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(1);
        list.add(4);
        list.add(7);
        list.add(2);
        list.add(9);
        list.add(3);
        list.add(7);
        list.add(2);
        list.add(9);
        list.add(4);
        list.add(7);
        list.add(2);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);


        System.out.println(s.sort(list));

    }
}
