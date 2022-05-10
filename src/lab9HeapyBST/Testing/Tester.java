package lab9HeapyBST.Testing;

import lab5_6SortingAlgorithms.testing.generation.Generator;
import lab9HeapyBST.Core.BSTInterface;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tester {
    public static <T> double insertValuesTest(List<T> values, BSTInterface<T> bst) {
        Instant start = Instant.now();
        for (int i = 0; i < values.size(); i++) {
            bst.insert(values.get(i));
        }
        Instant end = Instant.now();
        return Duration.between(start, end).toMillis();
    }

    public static <T> double findValuesTest(List<T> valuesInBst, BSTInterface<T> bst) {
        Random random = new Random();
        Instant start = Instant.now();
        for (int i = 0; i < valuesInBst.size(); i++) {
            bst.find(valuesInBst.get(random.nextInt(valuesInBst.size())));
        }
        Instant end = Instant.now();

        return Duration.between(start, end).toMillis();
    }

    public static <T> double deleteValuesTest(List<T> valuesInBst, BSTInterface<T> bst) {
        Instant start = Instant.now();
        for (int i = 0; i < 0.2 * valuesInBst.size(); i++) {
            bst.delete(valuesInBst.get(i)); //deleting value that is in tree
        }
        Instant end = Instant.now();

        return Duration.between(start, end).toMillis();
    }

    public static <T> List<Double> runOnce(BSTInterface<T> bst, Generator<T> generator, int size) {
        bst.clear();

        List<T> values = generator.generate(size);
        List<Double> returnList = new ArrayList<>();

        returnList.add(insertValuesTest(values, bst));
        returnList.add(findValuesTest(values, bst));
        returnList.add(deleteValuesTest(values, bst));

        return returnList;
    }

    public static <T> List<Result> runNTimes(BSTInterface<T> bst, Generator<T> generator, int size, int repetitions) {
        double avgInsertTime = 0.0;
        double avgInsertTimeSquared = 0.0;

        double avgFindTime = 0.0;
        double avgFindTimeSquared = 0.0;

        double avgDeleteTime = 0.0;
        double avgDeleteTimeSquared = 0.0;

        for (int i = 1; i <= repetitions; i++) {
            List<Double> results = runOnce(bst, generator, size);

            avgInsertTime = updatedAverage(avgInsertTime, results.get(0), i);
            avgInsertTimeSquared = updatedAverage(avgInsertTimeSquared, results.get(0) * results.get(0), i);

            avgFindTime = updatedAverage(avgFindTime, results.get(1), i);
            avgFindTimeSquared = updatedAverage(avgFindTimeSquared, results.get(1) * results.get(1), i);

            avgDeleteTime = updatedAverage(avgDeleteTime, results.get(2), i);
            avgDeleteTimeSquared = updatedAverage(avgDeleteTimeSquared, results.get(2) * results.get(2), i);
        }

        List<Result> res = new ArrayList<>();
        res.add(new Result(avgInsertTime, calculateStdDev(avgInsertTime, avgInsertTimeSquared)));
        res.add(new Result(avgFindTime, calculateStdDev(avgFindTime, avgFindTimeSquared)));
        res.add(new Result(avgDeleteTime, calculateStdDev(avgDeleteTime, avgDeleteTimeSquared)));

        return res;
    }

    private static double updatedAverage(double curAvg, double val, int n) {
        return curAvg + (val - curAvg) / n;
    }

    private static double calculateStdDev(double average, double averagedSquares) {
        return Math.sqrt(averagedSquares - (average * average));
    }

}
