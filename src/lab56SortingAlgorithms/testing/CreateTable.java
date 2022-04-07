package lab56SortingAlgorithms.testing;

import lab56SortingAlgorithms.core.SortingAlgorithm;
import lab56SortingAlgorithms.saving.SaveTableToTxt;
import lab56SortingAlgorithms.testing.generation.Generator;

import java.util.ArrayList;
import java.util.List;

public class CreateTable<T> {
    private SortingAlgorithm<MarkedValue<T>> algorithm;
    private Generator<MarkedValue<T>> generator;
    private final int minSize;
    private final int maxSize;
    private final int repetitions;
    private final String tableLabel;

    public CreateTable(SortingAlgorithm<MarkedValue<T>> algorithm, Generator<MarkedValue<T>> generator, int minSize, int maxSize, int repetitions, String tableLabel) {
        this.algorithm = algorithm;
        this.generator = generator;
        this.minSize = minSize;
        this.maxSize = maxSize;
        this.repetitions = repetitions;
        this.tableLabel = tableLabel;
        create();
    }

    public List<String> create() {
        List<String> rows = new ArrayList<>();
        rows.add(addFirstRow());
        Result result;
        for (int i = minSize; i < maxSize; i *= 2) {
            result = Tester.runNTimes(algorithm, generator, i, repetitions);

            rows.add(buildRow(result, i));

            printToConsole(result, i);

            if (i == 0) {
                i = 1;
            }
        }

        SaveTableToTxt.save(rows, tableLabel);

        return rows;
    }

    public String buildRow(Result result, int size) {
        return size + ";" +
                buildStatisticForRows(result.averageTimeInMilliseconds(), result.timeStandardDeviation()) + ";" +
                buildStatisticForRows(result.averageComparisons(), result.comparisonsStandardDeviation()) + ";" +
                buildStatisticForRows(result.averageSwaps(), result.swapsStandardDeviation()) + ";" +
                result.sorted() + ";" + result.stable();

    }

    public String addFirstRow() {
        return "Size;Time [ms];TimeStd;Comparisons;ComparisonsStd;Swaps;SwapsStd;AlwaysSorted;AlwaysStable";
    }

    public String buildStatisticForRows(double average, double stdDev) {
        return double2String(average) + ";" + double2String(stdDev);
    }

    private void printStatistic(String label, double average, double stdDev) {
        System.out.println(label + ": " + double2String(average) + " +- " + double2String(stdDev));
    }

    private String double2String(double value) {
        return String.format("%.12f", value);
    }

    private void printToConsole(Result result, int size) {
        System.out.println("\nSize: " + size);
        printStatistic("time [ms]", result.averageTimeInMilliseconds(), result.timeStandardDeviation());
        printStatistic("comparisons", result.averageComparisons(), result.comparisonsStandardDeviation());
        printStatistic("swaps", result.averageSwaps(), result.swapsStandardDeviation());

        System.out.println("always sorted: " + result.sorted());
        System.out.println("always stable: " + result.stable());
    }


}
