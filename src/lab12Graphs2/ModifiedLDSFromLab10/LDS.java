package lab12Graphs2.ModifiedLDSFromLab10;

public class LDS<T> implements DisjointSet<T> {
    @Override
    public LDSElement<T> makeSet(T element) {
        return new LDSElement<>(element);
    }

    @Override
    public LDSElement<T> union(LDSElement<T> x, LDSElement<T> y) {
        LDSElement<T> repr1 = x.getRepresentative();
        LDSElement<T> repr2 = y.getRepresentative();

        //setting repr1 set to be longer than repr2 set
        if (repr1.getLength() < repr2.getLength()) {
            LDSElement<T> temp = repr1;
            repr1 = repr2;
            repr2 = temp;
        }

        //connect repr1 set and repr2 set
        repr1.getLast().setNext(repr2);
        repr1.setLast(repr2.getLast());
        repr1.setLength(repr1.getLength() + repr2.getLength());

        //set representative of repr2 set to repr1 (iteration over set2 elements)
        while (repr2 != null) {
            repr2.setRepresentative(repr1);
            repr2 = repr2.getNext();
        }

        return repr1;
    }

    @Override
    public LDSElement<T> findSet(LDSElement<T> x) {
        return x.getRepresentative();
    }
}
