package lab2Iterators;

import java.util.Iterator;

public class SeriesIterator<E> implements Iterator<E> {
    private int i = 1;

    private SeriesGenerator<E> seriesGenerator;

    public SeriesIterator(SeriesGenerator<E> s) {
        seriesGenerator = s;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public E next() {
        return seriesGenerator.generate(i++);
    }

    public int getI(){
        return i;
    }

    public void setI(int i){
        this.i=i;
    }

    public SeriesGenerator<E> getSeriesGenerator(){
        return seriesGenerator;
    }


}
