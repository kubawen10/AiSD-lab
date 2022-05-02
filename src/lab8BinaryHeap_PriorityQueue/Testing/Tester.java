package lab8BinaryHeap_PriorityQueue.Testing;

import lab5_6SortingAlgorithms.testing.generation.Generator;
import lab8BinaryHeap_PriorityQueue.Sorter.PriorityQueueSorter;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class Tester {
    public static <T> double runOnce(PriorityQueueSorter<T> algorithm, Generator<T> generator, int size) {
        List<T> list = generator.generate(size);
        Instant start = Instant.now();
        list = algorithm.sort(list);
        Instant end = Instant.now();

        return Duration.between(start, end).toMillis();
    }

    public static <T> Result runNTimes(PriorityQueueSorter<T> algorithm, Generator<T> generator, int size, int repetitions) {
        double averageTime = 0.0;
        double averageTimeSquared = 0.0;

        for (int n = 1; n <= repetitions; ++n) {
            double result = runOnce(algorithm, generator, size);

            averageTime = updatedAverage(averageTime, result, n);
            averageTimeSquared = updatedAverage(averageTimeSquared, result * result, n);
        }

        return new Result(averageTime, calculateStdDev(averageTime, averageTimeSquared));
    }

    private static double updatedAverage(double average, double value, int n) {
        return average + (value - average) / n;
    }

    private static double calculateStdDev(double average, double averagedSquares) {
        return Math.sqrt(averagedSquares - (average * average));
    }
}
