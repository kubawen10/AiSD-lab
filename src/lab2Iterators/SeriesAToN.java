package lab2Iterators;

public class SeriesAToN<E> implements SeriesGenerator<E>{
    @Override
    public E generate(int n) {
        StringBuffer b = new StringBuffer();
        for (int i = 0; i < n; i++) {
            b.append("a");
        }
        return (E)(Object)(b.toString());
    }
}
