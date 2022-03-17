package lab2Iterators;

public class SeriesAToN<E> implements SeriesGenerator<String>{
    @Override
    public String generate(int n) {
        StringBuffer b = new StringBuffer();
        for (int i = 0; i < n; i++) {
            b.append("a");
        }
        return (b.toString());
    }
}
