package lab2Iterators;

public class Series2n<E> implements SeriesGenerator<Integer>{
    @Override
    public Integer generate(int n) {
        return (2*n);
    }
}
