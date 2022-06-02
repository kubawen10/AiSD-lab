package lab12Graphs2.MST;


import lab11Graphs1.WeightedGraph.IWeightedDigraph;
import lab12Graphs2.ModifiedLDSFromLab10.DisjointSet;
import lab12Graphs2.ModifiedLDSFromLab10.LDS;
import lab12Graphs2.ModifiedLDSFromLab10.LDSElement;

import java.util.ArrayList;


public abstract class MST {
    //set maker
    DisjointSet<Integer> set = new LDS<>();
    ArrayList<LDSElement<Integer>> sets;

    public abstract IWeightedDigraph makeMinimal(IWeightedDigraph graph);

    public boolean isMinimal(IWeightedDigraph graph) {
        //check if number of edges is equal to vertexCount - 1 (edges are in both directions so div/2)
        if (graph.vertexCount() - 1 != (graph.edgeCount() / 2)){
            return false;
        }



        return true;
    }
}
