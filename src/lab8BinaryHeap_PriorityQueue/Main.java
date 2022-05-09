package lab8BinaryHeap_PriorityQueue;

import lab5_6SortingAlgorithms.testing.generation.OrderedIntegerArrayGenerator;
import lab5_6SortingAlgorithms.testing.generation.RandomIntegerArrayGenerator;
import lab5_6SortingAlgorithms.testing.generation.ReversedIntegerArrayGenerator;
import lab5_6SortingAlgorithms.testing.generation.ShuffledIntegerArrayGenerator;
import lab7Hashing.Comparators.IntegerComparator;
import lab8BinaryHeap_PriorityQueue.Heaps.ArrayHeap;
import lab8BinaryHeap_PriorityQueue.Heaps.BinaryMinHeap;
import lab8BinaryHeap_PriorityQueue.Heaps.TreeHeap;
import lab8BinaryHeap_PriorityQueue.Sorter.PriorityQueueSorter;
import lab8BinaryHeap_PriorityQueue.Testing.Result;
import lab8BinaryHeap_PriorityQueue.Testing.Tester;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        int maxSize = 200000;
        Comparator<Integer> comparator = new IntegerComparator();

        BinaryMinHeap<Integer> arrayHeap = new ArrayHeap<>(10, comparator);
        BinaryMinHeap<Integer> treeHeap = new TreeHeap<>(comparator);

        PriorityQueueSorter<Integer> arraySorter = new PriorityQueueSorter<>(arrayHeap);
        PriorityQueueSorter<Integer> treeSorter = new PriorityQueueSorter<>(treeHeap);

        Result result;
        for (int size = 2041; size < maxSize; size += size) {
            result = Tester.runNTimes(arraySorter, new RandomIntegerArrayGenerator(200), size, 20);
            printResult(result, size, "arrayRandom");
            result = Tester.runNTimes(treeSorter, new RandomIntegerArrayGenerator(200), size, 20);
            printResult(result, size, "treeRandom");
            System.out.println();

            result = Tester.runNTimes(arraySorter, new ShuffledIntegerArrayGenerator(), size, 20);
            printResult(result, size, "arrayShuffled");
            result = Tester.runNTimes(treeSorter, new ShuffledIntegerArrayGenerator(), size, 20);
            printResult(result, size, "treeShuffled");
            System.out.println();

            result = Tester.runNTimes(arraySorter, new ReversedIntegerArrayGenerator(), size, 20);
            printResult(result, size, "arrayReversed");
            result = Tester.runNTimes(treeSorter, new ReversedIntegerArrayGenerator(), size, 20);
            printResult(result, size, "treeReversed");
            System.out.println();

            result = Tester.runNTimes(arraySorter, new OrderedIntegerArrayGenerator(), size, 20);
            printResult(result, size, "arrayOrdered");
            result = Tester.runNTimes(treeSorter, new OrderedIntegerArrayGenerator(), size, 20);
            printResult(result, size, "treeOrdered");


            System.out.println();
            System.out.println();
        }
    }

    public static void printResult(Result r, int size, String generator) {
        System.out.println("Generator: " + generator + "\t\tSize: " + size + "\t\t" + r);
    }
}
