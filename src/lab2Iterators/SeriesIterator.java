package lab2Iterators;

import java.util.Iterator;

public class SeriesIterator<E> implements Iterator<E> {
    private int n = 1;
    private SeriesGenerator<E> seriesGenerator;

    public SeriesIterator(SeriesGenerator<E> s) {
        seriesGenerator = s;
    }

    @Override
    public boolean hasNext() {
        return n<20;
    }

    @Override
    public E next() {
        return seriesGenerator.generate(n++);
    }
}
