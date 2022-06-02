package lab12Graphs2.ModifiedLDSFromLab10;

public interface DisjointSet<T> {
    LDSElement<T> makeSet(T element);
    LDSElement<T> union (LDSElement<T> x, LDSElement<T> y);
    LDSElement<T> findSet(LDSElement<T> x);
}
