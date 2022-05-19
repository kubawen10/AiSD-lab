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
        //cast :( how to change it?
        LDSElement r1 = ((LDSElement) x).getRepresentative();
        LDSElement r2 = ((LDSElement) y).getRepresentative();

        //setting r1 set to be longer than r2 set
        if (r1.getLength() < r2.getLength()) {
            LDSElement temp = r1;
            r1 = r2;
            r2 = temp;
        }

        r1.getLast().setNext(r2);
        r1.setLast(r2.getLast());

        r1.setLength(r1.getLength() + r2.getLength());
        while (r2 != null) {
            r2.setRepresentative(r1);
            r2 = r2.getNext();
        }


        return r1;
    }

    @Override
    public SetElement findSet(SetElement x) {
        return ((LDSElement) x).getRepresentative();
    }

    @Override
    public void printSet(SetElement x) {
        if(x==null){
            System.out.println("null");
            return;
        }
        LDSElement r = ((LDSElement) x).getRepresentative();
        System.out.println(r);
    }
}
