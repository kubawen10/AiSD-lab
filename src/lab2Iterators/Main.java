package lab2Iterators;

public class Main {
    public static void main(String[] args) {
//        SeriesGenerator<Integer> s2n = new Series2n<>();
//        SeriesIterator<Integer> it1 = new SeriesIterator<>(s2n);
//        for (int i = 0; i < 10; i++) {
//            System.out.println(it1.next());
//        }

//        SeriesGenerator<Integer> sAtoN = new SeriesAToN<>();
//        SeriesIterator<Integer> it2 = new SeriesIterator<>(sAtoN);
//        for (int i = 0; i < 10; i++) {
//            System.out.println(it2.next());
//        }

//        SeriesGenerator<String> sAtoN = new SeriesAToN<>();
//        SeriesIterator<String> it2 = new SeriesIterator<>(sAtoN);
//        for (int i = 0; i < 10; i++) {
//            System.out.println(it2.next());
//        }

//        SeriesGenerator<Integer> s2n = new Series2n<>();
//        Series<Integer> s1 = new Series<>(s2n);
//        for (Integer x : s1) {
//            System.out.println(x);
//        }

        SeriesGenerator<Integer> sEuler = new SeriesEuler<>();
        FiniteSeries<Integer> s2 = new FiniteSeries<>(sEuler, 5);
        for (Integer x : s2) {
            System.out.println(x);
        }

        System.out.println();
        for (Integer x :
                s2) {
            System.out.println(x);
        }
    }
}
