package lab12Graphs2.MST;

import lab11Graphs1.Iterators.WeightedEdge;
import lab11Graphs1.WeightedGraph.AdjacencyListWeightedDigraph;
import lab11Graphs1.WeightedGraph.AdjacencyMatrixWeightedDigraph;
import lab11Graphs1.WeightedGraph.IWeightedDigraph;
import lab12Graphs2.ModifiedLDSFromLab10.LDSElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class KruskalMST extends MST {
    @Override
    public IWeightedDigraph makeMinimal(IWeightedDigraph graph) {
        IWeightedDigraph returnGraph;

        System.out.println("Creating new graph");
        //decide which graph type to return
        if (graph instanceof AdjacencyListWeightedDigraph) {
            returnGraph = new AdjacencyListWeightedDigraph(graph.vertexCount());
        } else if (graph instanceof AdjacencyMatrixWeightedDigraph) {
            returnGraph = new AdjacencyMatrixWeightedDigraph(graph.vertexCount());
        } else {
            return null;
        }

        System.out.println("Starting creating sets");
        //sets of vertices
        sets = new ArrayList<>();
        //each vertex is disjoint set
        for (int i = 0; i < graph.vertexCount(); i++) {
            sets.add(set.makeSet(i));
        }
        System.out.println("created sets");
        //list of edges
        ArrayList<WeightedEdge> edges = new ArrayList<>();
        for (int i = 0; i < graph.vertexCount(); i++) {
            //iterate over each edge, they are undirected so skip already added
            Iterator<WeightedEdge> it = graph.edges(i);
            while (it.hasNext()) {
                WeightedEdge curEdge = it.next();
                //skip: if we have edge(u,v) and v < i, we already had edge(v,u)
                if (curEdge.end >= i) {
                    edges.add(curEdge);
                }
            }
        }
        System.out.println("created list of edges");
        //sort edges by weight, then by beginning edge, then by end edge
        Collections.sort(edges);
        System.out.println("sorted");

        for (int i = 0; i < edges.size(); i++) {
            WeightedEdge curEdge = edges.get(i);
            int from = curEdge.beginning;
            int to = curEdge.end;

            //check if two vertices are connected, they are if they are in same set (have equal representatives)
            LDSElement<Integer> reprFrom = set.findSet(sets.get(from));
            LDSElement<Integer> reprTo = set.findSet(sets.get(to));
            if (!reprFrom.equals(reprTo)) {
                returnGraph.addEdgeU(from, to, curEdge.weight);
                set.union(sets.get(from), sets.get(to));
            }
        }

        return returnGraph;
    }
}
