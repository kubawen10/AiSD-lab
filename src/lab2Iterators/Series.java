package lab2Iterators;

import java.util.Iterator;

public class Series<E> implements Iterable<E>{
    private SeriesGenerator<E> s;
    public Series(SeriesGenerator<E> s){
        this.s=s;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new SeriesIterator<>(s);
        return it;
    }
}
