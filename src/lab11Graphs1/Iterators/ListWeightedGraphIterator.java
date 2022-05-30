package lab11Graphs1.Iterators;

import lab11Graphs1.WeightedGraph.WeightedArc;

import java.util.Iterator;
import java.util.LinkedList;

public class ListWeightedGraphIterator implements Iterator<WeightedEdge> {
    private int v;
    private Iterator<WeightedArc> inner;

    public ListWeightedGraphIterator(int v, LinkedList<WeightedArc> arcs) {
        this.inner = arcs.iterator();
        this.v = v;
    }

    @Override
    public boolean hasNext() {
        return inner.hasNext();
    }

    @Override
    public WeightedEdge next() {
        WeightedArc n = inner.next();
        return new WeightedEdge(v, n.getToVertex(), n.getWeight());
    }
}
