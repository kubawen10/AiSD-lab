package lab7Hashing.IncrementalFunctions;

public class QuadraticIncrementalFunction<T> implements IncrementalFunction<T> {
    @Override
    public int shift(T object, int trial) {
        return trial + 2*(trial * trial);
    }
}
