package lab56SortingAlgorithms;

import java.util.Comparator;

import lab56SortingAlgorithms.core.SortingAlgorithm;
import lab56SortingAlgorithms.testing.*;
import lab56SortingAlgorithms.testing.comparators.*;
import lab56SortingAlgorithms.testing.generation.*;
import lab56SortingAlgorithms.testing.generation.conversion.*;

public class Main {

    public static void main(String[] args) {
        Comparator<MarkedValue<Integer>> markedComparator;
        Generator<MarkedValue<Integer>> generator;
        SortingAlgorithm<MarkedValue<Integer>> algorithm;
        CreateTable<Integer> createTable;

        markedComparator = new MarkedValueComparator<Integer>(new IntegerComparator());
        generator = new MarkingGenerator<Integer>(new ReversedIntegerArrayGenerator());

        algorithm = new MergeSortList<>(markedComparator);
        // = new CreateTable<>(algorithm, generator, 0, 132000, 20, "MergeSortListReversedIntegers");

        algorithm = new MergeSortArray<>(markedComparator);
        //createTable = new CreateTable<>(algorithm, generator, 0, 132000, 20, "MergeSortArrayReversedIntegers");


        generator = new LinkedListGenerator<>(generator);
        algorithm = new QuickSort<>(markedComparator, false);
        createTable = new CreateTable<>(algorithm, generator, 0, 4097*2, 20, "QuickSortPivot0ReversedIntegers");

        algorithm = new QuickSort<>(markedComparator, true);
        //createTable = new CreateTable<>(algorithm, generator, 0, 132000, 20, "QuickSortRandomPivotReversedIntegers");
    }

    private static void printStatistic(String label, double average, double stdDev) {
        System.out.println(label + ": " + double2String(average) + " +- " + double2String(stdDev));
    }

    private static String double2String(double value) {
        return String.format("%.12f", value);
    }
}
