package lab7Hashing.IncrementalFunctions;

public class LinearIncrementalFunction<T> implements IncrementalFunction<T> {
    @Override
    public int shift(T object, int trial) {
        return trial;
    }
}
