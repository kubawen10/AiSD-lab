package lab2Iterators;

public class SeriesEuler<E> implements SeriesGenerator<E>{
    @Override
    public E generate(int n) {
        return (E)(Object)(n*n-n+41);
    }
}
