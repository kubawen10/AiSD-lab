package lab12Graphs2;

import lab11Graphs1.Loader.Loader;
import lab11Graphs1.WeightedGraph.IWeightedDigraph;
import lab12Graphs2.MST.KruskalMST;
import lab12Graphs2.MST.MST;

public class Main {

    public static String pathToGraphs = "src/Lab12Graphs2/Graphs/";

    public static void main(String[] args) {
        IWeightedDigraph listGraph = Loader.listGraphLoader(pathToGraphs + "G1.txt");
        IWeightedDigraph matrixGraph = Loader.matrixGraphLoader(pathToGraphs + "G1.txt");

        MST kruskalMST = new KruskalMST();
        IWeightedDigraph minmimalFromList = kruskalMST.makeMinimal(listGraph);
        System.out.println(kruskalMST.isMinimal(minmimalFromList));
    }
}
