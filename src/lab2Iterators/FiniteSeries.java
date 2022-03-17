package lab2Iterators;

import java.util.Iterator;

public class FiniteSeries<E> extends SeriesIterator<E> implements Iterable<E> {
    private int N;

    public FiniteSeries(SeriesGenerator<E> s, int N) {
        super(s);
        this.N = N;
    }

    @Override
    public boolean hasNext() {
        return getI() <= N;
    }

    @Override
    public Iterator<E> iterator() {
        return new FiniteSeries<E>(getSeriesGenerator(), N);
    }
}
