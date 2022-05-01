package lab8BinaryHeap_PriorityQueue;

import lab7Hashing.Comparators.IntegerComparator;

public class Main {
    public static void main(String[] args) {
        BinaryMinHeap<Integer> h = new ArrayHeap<>(10, new IntegerComparator());

        h.add(1);
        h.add(2);
        h.add(3);
        h.add(4);
        h.add(5);
        h.add(6);
        h.add(7);
        h.add(8);
        h.add(9);
        h.add(10);
        h.add(11);
        h.add(12);
        h.add(13);
        h.add(14);
        h.add(15);
        h.add(16);




        System.out.println(h);
        System.out.println();
        System.out.println(h.minimum());
        System.out.println(h);
//
//        System.out.println(h.minimum());
//        System.out.println(h);
    }
}
