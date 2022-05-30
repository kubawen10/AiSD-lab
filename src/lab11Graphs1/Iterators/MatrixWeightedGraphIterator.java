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
        int from;

        if (curPos == -1) {
            from = 0;
        } else {
            from = curPos + 1;
        }

        System.out.println("from: " + from);
        for (int i = from; i < adj.size(); i++) {
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

        curPos = adj.size() + 1;
    }

    @Override
    public WeightedEdge next() {
        setNext();

        System.out.println("cur Pos : " + curPos);
        return new WeightedEdge(v, curPos, adj.get(curPos));
    }
}
