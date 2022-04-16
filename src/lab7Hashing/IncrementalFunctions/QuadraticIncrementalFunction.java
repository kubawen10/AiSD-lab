package lab7Hashing.IncrementalFunctions;

import lab7Hashing.IncrementalFunction;

public class QuadraticIncrementalFunction<T> implements IncrementalFunction<T> {
    @Override
    public int shift(T object, int trial) {
        return trial + trial * trial;
    }
}
