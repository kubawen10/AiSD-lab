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
        FDSElement repr1 = privFindSet(cast(x));
        FDSElement repr2 = privFindSet(cast(y));

        return link(repr1, repr2);
    }

    private SetElement link(FDSElement repr1, FDSElement repr2) {
        int rank1 = repr1.getRank();
        int rank2 = repr2.getRank();

        if (rank1 > rank2) {
            repr2.setParent(repr1);

            return repr1;
        } else {
            repr1.setParent(repr2);

            if (rank1 == rank2) {
                repr2.setRank(rank2 + 1);
            }

            return repr2;
        }
    }

    @Override
    public SetElement findSet(SetElement x) {
        return privFindSet(cast(x));
    }

    private FDSElement privFindSet(FDSElement x) {
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
