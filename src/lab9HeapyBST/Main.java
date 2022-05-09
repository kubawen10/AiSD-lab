package lab9HeapyBST;

import lab7Hashing.Comparators.IntegerComparator;
import lab9HeapyBST.HeapyBST.HeapyBST;

public class Main {
    public static void main(String[] args) {
        HeapyBST<Integer> h = new HeapyBST<>(new IntegerComparator());

        h.insert(20);
        h.insert(15);
        h.insert(30);
        h.insert(17);
        h.insert(28);
        h.insert(29);
        h.insert(40);
        h.insert(27);
        h.insert(22);

        System.out.println(h.preOrderWalk());
        System.out.println(h.inOrderWalk());
        System.out.println(h.postOrderWalk());

        System.out.println(h.printLevels());

        h.delete(20);
        System.out.println(h.printLevels());
    }
}
