package lab2Iterators;

public class Series2n<E> implements SeriesGenerator<E>{
    @Override
    public E generate(int n) {
        return (E)(Object)(2*n);
    }
}
