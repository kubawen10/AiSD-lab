package lab10DisjointSets;

public interface DisjointSet {
    SetElement makeSet();
    SetElement union(SetElement x, SetElement y);
    SetElement findSet(SetElement x);
    void printSet(SetElement x);
}
