package lab5SortingAlgorithms;

import java.util.Comparator;

import lab5SortingAlgorithms.core.SortingAlgorithm;
import lab5SortingAlgorithms.testing.*;
import lab5SortingAlgorithms.testing.comparators.*;
import lab5SortingAlgorithms.testing.generation.*;
import lab5SortingAlgorithms.testing.generation.conversion.*;

public class Main {

    public static void main(String[] args) {
        Comparator<MarkedValue<Integer>> markedComparator;
        Generator<MarkedValue<Integer>> generator;
        SortingAlgorithm<MarkedValue<Integer>> algorithm;
        CreateTable<Integer> createTable;

        markedComparator = new MarkedValueComparator<Integer>(new IntegerComparator());
        generator = new MarkingGenerator<Integer>(new RandomIntegerArrayGenerator(200));
//        algorithm = new BubbleSort<>(markedComparator);
//        algorithm = new InsertionSort<>(markedComparator);
//        algorithm = new SelectSort<>(markedComparator);
        algorithm = new ShakerSort<>(markedComparator);
        createTable = new CreateTable<>(algorithm, generator, 0, 20000, 20, "ShakerSortSortRandomIntegersDontCheck");

//        Result result = Tester.runNTimes(algorithm, generator, 65, 20);
//
//        printStatistic("time [ms]", result.averageTimeInMilliseconds(), result.timeStandardDeviation());
//        printStatistic("comparisons", result.averageComparisons(), result.comparisonsStandardDeviation());
//        printStatistic("swaps", result.averageSwaps(), result.swapsStandardDeviation());
//
//        System.out.println("always sorted: " + result.sorted());
//        System.out.println("always stable: " + result.stable());
    }

    private static void printStatistic(String label, double average, double stdDev) {
        System.out.println(label + ": " + double2String(average) + " +- " + double2String(stdDev));
    }

    private static String double2String(double value) {
        return String.format("%.12f", value);
    }

}
