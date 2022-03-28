package lab4ListaDwukierunkowaZWewnLista;

public class Main {
    public static void main(String[] args) {
        TwoWayArrayLinkedList<String> l = new TwoWayArrayLinkedList<>(5);
        System.out.println(l.isEmpty());
        l.add("a");
        System.out.println(l.isEmpty());
        l.clear();
        System.out.println(l.isEmpty());
        l.add("a");
        l.add("b");
        l.add("c");
        l.add("d");
        l.add("e");

        l.add("f");
        l.add("g");
        l.add("h");
        l.add("i");
        l.add("j");

        l.add("k");
        l.add("l");
        l.add("m");
        l.add("n");
        System.out.println(l);

        l.add(10, "x");
        System.out.println(l);
        l.add(9, "y");
        System.out.println(l);
        l.add(8, "z");
        System.out.println(l);

//        System.out.println("USUWANIE");
//        System.out.println(l.remove(6));
//        System.out.println(l);
//        System.out.println(l.remove(7));
//        System.out.println(l);
//        System.out.println(l.remove(8));
//        System.out.println(l);
//
//        l.add("na koniec");
//        System.out.println(l);
//
//        l.add(7, "hi");
//        System.out.println(l);
//        l.add(8, "abc");
//        System.out.println(l);
//        l.add(7, "hiii");
//        System.out.println(l);
//        l.add(7, "xyz");
        System.out.println(l);

        l.remove(15);
        l.remove(15);
        System.out.println(l);
    }
}
