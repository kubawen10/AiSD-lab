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

        BinaryMinHeap<Integer> heap = new ArrayHeap<>(10, comparator);
        PriorityQueueSorter<Integer> sorter = new PriorityQueueSorter<>(heap);

//        BinaryMinHeap<Integer> heap = new TreeHeap<>(comparator);
//        PriorityQueueSorter<Integer> sorter = new PriorityQueueSorter<>(heap);

        Result result;
        for (int size = 1; size < maxSize; size += size + 7) {
            result = Tester.runNTimes(sorter, new RandomIntegerArrayGenerator(200), size, 20);
            printResult(result, size, "Random");

            result = Tester.runNTimes(sorter, new ShuffledIntegerArrayGenerator(), size, 20);
            printResult(result, size, "Shuffled");

            result = Tester.runNTimes(sorter, new ReversedIntegerArrayGenerator(), size, 20);
            printResult(result, size, "Reversed");

            result = Tester.runNTimes(sorter, new OrderedIntegerArrayGenerator(), size, 20);
            printResult(result, size, "Ordered");
            System.out.println();
            System.out.println();
        }
    }

    public static void printResult(Result r, int size, String generator) {
        System.out.println("Generator: " + generator + "\t\tSize: " + size + "\t\t" + r);
    }
}
