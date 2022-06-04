package lab12Graphs2.MST;


import lab11Graphs1.WeightedGraph.IWeightedDigraph;
import lab12Graphs2.ModifiedLDSFromLab10.DisjointSet;
import lab12Graphs2.ModifiedLDSFromLab10.LDS;
import lab12Graphs2.ModifiedLDSFromLab10.LDSElement;

import java.util.ArrayList;
import java.util.List;


public abstract class MST {
    //set maker
    DisjointSet<Integer> set = new LDS<>();
    ArrayList<LDSElement<Integer>> sets;

    public abstract IWeightedDigraph makeMinimal(IWeightedDigraph graph);

    public static boolean checker(IWeightedDigraph graph) {
        //check if number of edges is equal to vertexCount - 1 (edges are in both directions so div/2)
        if (graph.vertexCount() - 1 != (graph.edgeCount() / 2)) {
            System.out.println("There should be V-1 edges, where V is number of vertices");
            return false;
        }

        boolean isAcyclic = isTree(graph);
        return isAcyclic;

    }

    private static boolean isTree(IWeightedDigraph graph) {
        // to keep track of whether a vertex is discovered or not
        boolean[] discovered = new boolean[graph.vertexCount()];

        //dfs from first vertex, determine acyclic
        boolean isTree = DFS(graph, 0, discovered, -1);

        //determine consistent? (spojny)
        for (int i = 0; isTree && i < graph.vertexCount(); i++) {
            if (!discovered[i]) {
                System.out.println("Disconnected part of graph");
                isTree = false;
            }
        }

        return isTree;
    }

    private static boolean DFS(IWeightedDigraph graph, int v, boolean[] discovered, int parent) {
        //mark current vertex as discovered
        discovered[v] = true;

        //iterate over adjectives
        List<Integer> adj = graph.verticesConnectedTo(v);
        for (int i = 0; i < adj.size(); i++) {
            int curAdj = adj.get(i);

            //if we havent discovered current adjective yet, we discover it and perform dfs on it
            if (!discovered[curAdj]) {
                if (!DFS(graph, curAdj, discovered, v)) {
                    return false;
                }
            }//if current adj has been discovered and it isnt our parent, there is a cycle, return false
            else if (curAdj != parent) {
                return false;
            }
        }
        //return true if none of the adj were discovered before
        return true;
    }


}
