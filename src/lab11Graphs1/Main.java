package lab11Graphs1;

import lab11Graphs1.WeightedGraph.AdjacencyListWeightedDigraph;
import lab11Graphs1.WeightedGraph.AdjacencyMatrixWeightedDigraph;
import lab11Graphs1.WeightedGraph.IWeightedDigraph;

public class Main {
    public static void main(String[] args) {
        System.out.println("General tests for matrix");
        AdjacencyMatrixWeightedDigraph matrix = new AdjacencyMatrixWeightedDigraph(5);
        //testGeneral(matrix);

        System.out.println("General tests for list");
        AdjacencyListWeightedDigraph list = new AdjacencyListWeightedDigraph(5);
        //testGeneral(list);


        System.out.println("Conversions test");
        //conversions test
        testConversions();


    }

    public static void testConversions(){
        AdjacencyListWeightedDigraph list = new AdjacencyListWeightedDigraph(5);
        System.out.println("Empty list to matrix: ");
        Converter converter = new Converter();
        System.out.println(list);
        AdjacencyMatrixWeightedDigraph matrix = converter.convert(list);
        System.out.println(matrix);


        System.out.println("Added some values to list");
        list.addEdgeU(1, 3, 4);
        list.addEdge(4, 2, 0);
        list.addEdgeU(2, 3, 8);
        System.out.println(list);
        matrix = converter.convert(list);
        System.out.println(matrix);

        System.out.println("Empty matrix to list");
        matrix=new AdjacencyMatrixWeightedDigraph(5);
        System.out.println(matrix);
        list = converter.convert(matrix);
        System.out.println(list);

        System.out.println("Added some values to matrix");
        matrix.addEdgeU(1, 3, 4);
        matrix.addEdge(4, 2, 0);
        matrix.addEdgeU(2, 3, 8);
        System.out.println(matrix);
        list = converter.convert(matrix);
        System.out.println(list);
    }

    public static void testGeneral(IWeightedDigraph g) {
        System.out.println(g);

        //adding out of range doesnt affect graph
        System.out.println("Add oob: " + g.addEdge(g.vertexCount() + 1, -1, 1));
        System.out.println(g);

        //adding at (u,u) doesnt change weight
        System.out.println("Add (u,u)" + g.addEdge(0, 0, 4));
        System.out.println(g);

        //normal add (0, 1)
        System.out.println("Normal add (0,1): " + g.addEdge(0, 1, 3));
        System.out.println(g);

        //addU at taken position
        System.out.println("AddU (u,v) at (v,u) taken position: " + g.addEdgeU(1, 0, 2));
        System.out.println(g);

        //addU at not taken position
        System.out.println("Normal addU (2,0) and (0,2): " + g.addEdgeU(2, 0, 2));
        System.out.println(g);

        System.out.println("Vertices connected to 0: " + g.verticesConnectedTo(0));

        System.out.println("Edge count: " + g.edgeCount());
        System.out.println("Weight (u,u): " + g.weight(1, 1));
        System.out.println("Weight (0,1): " + g.weight(0, 1));
        System.out.println("Set weight (0,1) to 5");
        g.setWeight(0, 1, 5);
        System.out.println(g);

        //remove at (u,u)
        System.out.println("Remove at (u,u)" + g.removeEdge(0, 0));
        System.out.println(g);

        //remove oob
        System.out.println("remove oob: " + g.removeEdge(-1, g.vertexCount() + 1));

        //removeU for directed graph
        System.out.println("Directed removeU: " + g.removeEdgeU(0, 1));
        System.out.println(g);

        //normal removeU
        System.out.println("Normal removeU: " + g.removeEdgeU(0, 2));
        System.out.println(g);

        //remove non-existing
        System.out.println("Non-existing remove: " + g.removeEdge(1, 2));
        System.out.println(g);
    }
}
