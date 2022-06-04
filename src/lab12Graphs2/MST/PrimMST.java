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
        ArrayList<WeightFrom> distances = new ArrayList<>(graph.vertexCount());
        distances.add(new WeightFrom(0.0, -1));
        for (int i = 1; i < graph.vertexCount(); i++) {
            if (graph.hasEdge(0, i)) {
                distances.add(new WeightFrom(graph.weight(0, i), 0));
            } else {
                distances.add(new WeightFrom(Double.POSITIVE_INFINITY, -1));
            }
        }

        while (sets.get(0).getLength() != graph.vertexCount()) {
            WeightedEdge minimalEdge = findMinimalEdge(distances);
            returnGraph.addEdgeU(minimalEdge.beginning, minimalEdge.end, minimalEdge.weight);
            set.union(sets.get(0), sets.get(minimalEdge.end));

            updateDistances(distances, minimalEdge.end, graph);
        }


        return returnGraph;
    }

    private WeightedEdge findMinimalEdge(ArrayList<WeightFrom> distances) {
        double minDist = Double.POSITIVE_INFINITY;
        int from = -1;
        int to = -1;

        LDSElement<Integer> source = sets.get(0);
        for (int i = 0; i < sets.size(); i++) {
            LDSElement<Integer> cur = sets.get(i);

            //if curent vertex hasnt been added to set
            if (!source.equals(set.findSet(cur))) {
                double dist = distances.get(i).getWeight();
                if (dist < minDist) {
                    minDist = dist;
                    from = distances.get(i).getFrom();
                    to = i;
                }
            }
        }
        if(from == -1 || to ==-1){
            System.out.println("Graph is not consisten");
            throw new IndexOutOfBoundsException();
        }
        return new WeightedEdge(from, to, minDist);
    }

    private void updateDistances(ArrayList<WeightFrom> distances, int from, IWeightedDigraph graph) {
        LDSElement<Integer> source = sets.get(0);
        List<Integer> connected = graph.verticesConnectedTo(from);

        for (int i = 0; i < connected.size(); i++) {
            int cur = connected.get(i);

            if (!source.equals(set.findSet(sets.get(cur)))) {
                double curWeight = distances.get(cur).getWeight();
                double newWeight = graph.weight(from, cur);
                if (newWeight < curWeight) {
                    distances.set(cur, new WeightFrom(newWeight, from));
                }
                //this is just to make it alphabetical order (G1 explains)
                else if (newWeight == curWeight) {
                    if (from < distances.get(cur).getFrom()) {
                        distances.set(cur, new WeightFrom(newWeight, from));
                    }
                }
            }
        }


    }
}
