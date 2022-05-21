package lab10DisjointSets.ForestDisjointSet;

import lab10DisjointSets.SetElement;

public class FDSElement extends SetElement {
    private FDSElement parent;
    private int rank;

    public FDSElement() {
        this.parent = this;
        rank = 0;
    }

    public FDSElement getParent() {
        return parent;
    }

    public void setParent(FDSElement parent) {
        this.parent = parent;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
