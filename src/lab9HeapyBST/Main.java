package lab9HeapyBST;

import lab5_6SortingAlgorithms.testing.generation.Generator;
import lab5_6SortingAlgorithms.testing.generation.ShuffledIntegerArrayGenerator;
import lab7Hashing.Comparators.IntegerComparator;
import lab9HeapyBST.Core.BSTInterface;
import lab9HeapyBST.HeapyBST.HeapyBST;
import lab9HeapyBST.NormalBST.BST;
import lab9HeapyBST.Testing.Result;
import lab9HeapyBST.Testing.Tester;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Generator<Integer> generator = new ShuffledIntegerArrayGenerator();
        Comparator<Integer> comparator = new IntegerComparator();

        BSTInterface<Integer> heapyBST = new HeapyBST<>(comparator);
        BSTInterface<Integer> normalBST = new BST<>(comparator);

        List<List<Result>> heapyResults = new ArrayList<>();
        List<List<Result>> normalResults = new ArrayList<>();

        for (int i = 1; i < 102500; i+=i) {
            heapyResults.add(Tester.runNTimes(heapyBST, generator, i, 20));
            normalResults.add(Tester.runNTimes(normalBST, generator, i, 20));
        }

        printResults(heapyResults, normalResults);
    }

    public static void printResults(List<List<Result>> l1, List<List<Result>> l2){{
        System.out.println("heapy - normal");
        int size = 1;
        for (int i = 0; i < l1.size(); i++) {
            System.out.println("Size: " + size);
            System.out.println("Insertion time: " + l1.get(i).get(0) + "\t\t" +  l2.get(i).get(0));
            System.out.println("Find time: " + l1.get(i).get(1) + "\t\t" +  l2.get(i).get(1));
            System.out.println("Delete time: " + l1.get(i).get(2) + "\t\t" +  l2.get(i).get(2));
            size+=size;
        }
    }

    }
}
