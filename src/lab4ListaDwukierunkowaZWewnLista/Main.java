package lab4ListaDwukierunkowaZWewnLista;

public class Main {
    public static void main(String[] args) {
        TwoWayArrayLinkedList<String> l = new TwoWayArrayLinkedList<>(5);
        System.out.println(l.isEmpty());
        l.add("a");
        System.out.println(l.isEmpty());
        l.clear();
        l.defragment();
        l.remove("z");
        l.capacity();
        l.endCapacity();
        //l.get(1);
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

        l.add(9, "x");
        l.add(9, "y");
        l.add(9, "z");
        l.add(10, "1");
        l.add(11, "2");
        l.remove(4);
        System.out.println(l);


        System.out.println("Defragment test");
        System.out.println(l.toStringPriti());
        l.defragment();
        System.out.println(l.toStringPriti());

        System.out.println(l);

        //l.wyp();
    }
}
