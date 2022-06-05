package lab12Graphs2;

import lab11Graphs1.Converter;
import lab11Graphs1.Loader.Loader;
import lab11Graphs1.WeightedGraph.AdjacencyListWeightedDigraph;
import lab11Graphs1.WeightedGraph.IWeightedDigraph;
import lab12Graphs2.MST.KruskalMST;
import lab12Graphs2.MST.MST;
import lab12Graphs2.MST.PrimMST;

import java.time.Duration;
import java.time.Instant;

public class Main {
    //medium 250 vertices, 1273 undirected edges
    public static void main(String[] args) {
        String pathToGraphs = "src/Lab12Graphs2/Graphs/";
        //test(pathToGraphs + "G1.txt");
        //test(pathToGraphs + "tinyG.txt");
        //test(pathToGraphs + "M250.txt");
        //test(pathToGraphs + "L1000.txt");
        //test(pathToGraphs + "XL10000.txt");
    }

    public static void test(String path) {
        IWeightedDigraph listGraph = Loader.listGraphLoader(path);
        IWeightedDigraph matrixGraph = Loader.matrixGraphLoader(path);
        System.out.println("Number of vertices: " + listGraph.vertexCount() + " Number of directed edges: " + listGraph.edgeCount() / 2);

        MST kruskalMST = new KruskalMST();
        MST primMST = new PrimMST();
        Instant start;
        Instant end;
        IWeightedDigraph mst;

        start = Instant.now();
        mst = kruskalMST.makeMinimal(listGraph);
        end = Instant.now();
        System.out.println("Kruskal list time: " + Duration.between(start, end).toMillis() + " Is MST: " + MST.checker(mst));

        start = Instant.now();
        mst = kruskalMST.makeMinimal(matrixGraph);
        end = Instant.now();
        System.out.println("Kruskal matrix time: " + Duration.between(start, end).toMillis() + " Is MST: " + MST.checker(mst));

        start = Instant.now();
        mst = primMST.makeMinimal(listGraph);
        end = Instant.now();
        System.out.println("Prim list time: " + Duration.between(start, end).toMillis() + " Is MST: " + MST.checker(mst));

        start = Instant.now();
        mst = primMST.makeMinimal(matrixGraph);
        end = Instant.now();
        System.out.println("Prim matrix time: " + Duration.between(start, end).toMillis() + " Is MST: " + MST.checker(mst));
        System.out.println();
    }
}
