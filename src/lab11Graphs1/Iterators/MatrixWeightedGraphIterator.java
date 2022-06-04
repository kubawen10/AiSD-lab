package lab11Graphs1.Iterators;

import java.util.ArrayList;
import java.util.Iterator;

public class MatrixWeightedGraphIterator implements Iterator<WeightedEdge> {
    private ArrayList<Double> adj;
    private int v;
    private int curPos = -1;

    public MatrixWeightedGraphIterator(int v, ArrayList<Double> adj) {
        this.v = v;
        this.adj = adj;
    }

    @Override
    public boolean hasNext() {
        for (int i = curPos + 1; i < adj.size(); i++) {
            if (adj.get(i) != Double.POSITIVE_INFINITY) {
                return true;
            }
        }

        return false;
    }

    private void setNext() {
        for (int i = curPos + 1; i < adj.size(); i++) {
            if (adj.get(i) != Double.POSITIVE_INFINITY) {
                curPos = i;
                return;
            }
        }

        curPos = adj.size();
    }

    @Override
    public WeightedEdge next() {
        setNext();
        return new WeightedEdge(v, curPos, adj.get(curPos));
    }
}
