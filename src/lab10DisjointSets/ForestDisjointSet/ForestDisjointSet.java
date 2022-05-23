package lab10DisjointSets.ForestDisjointSet;

import lab10DisjointSets.DisjointSet;
import lab10DisjointSets.SetElement;

public class ForestDisjointSet implements DisjointSet {
    public ForestDisjointSet() {
    }

    @Override
    public SetElement makeSet() {
        return new FDSElement();
    }

    @Override
    public SetElement union(SetElement x, SetElement y) {
        SetElement repr1 = findSet(x);
        SetElement repr2 = findSet(y);

        return link(repr1, repr2);
    }

    private SetElement link(SetElement repr1, SetElement repr2) {
        FDSElement r1 = cast(repr1);
        FDSElement r2 = cast(repr2);

        int rank1 = r1.getRank();
        int rank2 = r2.getRank();

        if (rank1 > rank2) {
            r2.setParent(r1);

            return repr1;
        } else {
            r1.setParent(r2);

            if (rank1 == rank2) {
                r2.setRank(rank2 + 1);
            }

            return repr2;
        }
    }

    @Override
    public SetElement findSet(SetElement x) {
        return privFindSet(x);
    }

    private FDSElement privFindSet(SetElement y) {
        FDSElement x =  cast(y);
        if (x != x.getParent()) {
            x.setParent(privFindSet(x.getParent()));
        }

        return x.getParent();
    }

    private FDSElement cast(SetElement x) {
        if (x instanceof FDSElement) {
            return (FDSElement) x;
        }

        throw new ClassCastException();
    }
}
