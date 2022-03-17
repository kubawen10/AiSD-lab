package lab2Iterators;

public class SeriesEuler<E> implements SeriesGenerator<Integer>{
    @Override
    public Integer generate(int n) {
        return (n*n-n+41);
    }
}
