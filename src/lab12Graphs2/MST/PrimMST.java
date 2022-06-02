package lab12Graphs2.MST;

import lab11Graphs1.Iterators.WeightedEdge;
import lab11Graphs1.WeightedGraph.AdjacencyListWeightedDigraph;
import lab11Graphs1.WeightedGraph.AdjacencyMatrixWeightedDigraph;
import lab11Graphs1.WeightedGraph.IWeightedDigraph;
import lab12Graphs2.ModifiedLDSFromLab10.LDSElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimMST extends MST {
    @Override
    public IWeightedDigraph makeMinimal(IWeightedDigraph graph) {
        IWeightedDigraph returnGraph;

        //decide which graph type to return
        if (graph instanceof AdjacencyListWeightedDigraph) {
            returnGraph = new AdjacencyListWeightedDigraph(graph.vertexCount());
        } else if (graph instanceof AdjacencyMatrixWeightedDigraph) {
            returnGraph = new AdjacencyMatrixWeightedDigraph(graph.vertexCount());
        } else {
            return null;
        }

        //sets of vertices
        sets = new ArrayList<>();
        //each vertex is disjoint set
        for (int i = 0; i < graph.vertexCount(); i++) {
            sets.add(set.makeSet(i));
        }

        //init distances, vertex 0 is source
        ArrayList<Double> distances = new ArrayList<>(graph.vertexCount());
        distances.add(0.0);
        for (int i = 1; i < graph.vertexCount(); i++) {
            if (graph.hasEdge(0, i)) {
                distances.add(graph.weight(0, i));
            } else {
                distances.add(Double.POSITIVE_INFINITY);
            }
        }

        while (sets.get(0).getLength() != graph.vertexCount()) {
            WeightedEdge minimalEdge = findMinimalEdge(distances);

        }


        return returnGraph;
    }

    private WeightedEdge findMinimalEdge(ArrayList<Double> distances) {
        double minDist = Double.POSITIVE_INFINITY;
        int from = -1;
        int to = -1;

        LDSElement<Integer> source = sets.get(0);
        for (int i = 0; i < sets.size(); i++) {
            LDSElement<Integer> cur = sets.get(i);

            //if curent vertex hasnt been added to set
            if (!source.equals(set.findSet(cur))) {
                double dist = distances.get(i);
                if (dist < minDist) {
                    minDist = dist;
                    to = i;
                }
            }
        }
        if (to == -1) return null;
    }

    private void updateDistances(ArrayList<Double> distances, int from, IWeightedDigraph graph) {
        LDSElement<Integer> source = sets.get(0);
        List<Integer> connected = graph.verticesConnectedTo(from);

        for (int i = 0; i < connected.size(); i++) {
            int cur = connected.get(i);

            if (!source.equals(set.findSet(sets.get(cur)))) {
                distances.set(cur, Math.min(distances.get(cur), graph.weight(from, cur)));
            }
        }


    }
}
