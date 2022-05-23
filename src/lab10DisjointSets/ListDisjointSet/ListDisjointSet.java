package lab10DisjointSets.ListDisjointSet;

import lab10DisjointSets.DisjointSet;
import lab10DisjointSets.SetElement;

public class ListDisjointSet implements DisjointSet {
    public ListDisjointSet() {
    }

    @Override
    public SetElement makeSet() {
        return new LDSElement();
    }

    @Override
    public SetElement union(SetElement x, SetElement y) {
        LDSElement repr1 = cast(x);
        LDSElement repr2 = cast(y);

        //setting repr1 set to be longer than repr2 set
        if (repr1.getLength() < repr2.getLength()) {
            LDSElement temp = repr1;
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
    public SetElement findSet(SetElement x) {
        return cast(x).getRepresentative();
    }

    private LDSElement cast(SetElement x){
        if(x instanceof  LDSElement){
            return (LDSElement) x;
        }

        throw new ClassCastException();
    }
}
