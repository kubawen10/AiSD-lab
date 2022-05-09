package lab9HeapyBST.Testing;

import lab9HeapyBST.Core.BSTInterface;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class Tester {
    public static <T> double addValuesTest(List<T> values, BSTInterface<T> bst){
        Instant start = Instant.now();
        for (int i = 0; i < values.size(); i++) {
            bst.insert(values.get(i));
        }
        Instant end = Instant.now();
        return Duration.between(start, end).toMillis();
    }

    public static <T> double findValuesTest(List<T> values, BSTInterface<T> bst){
        Instant start = Instant.now();
        for (int i = 0; i < values.size(); i++) {
            bst.insert(values.get(i));
        }
        Instant end = Instant.now();
        return Duration.between(start, end).toMillis();
    }

}
