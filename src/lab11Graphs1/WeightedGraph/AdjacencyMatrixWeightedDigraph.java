package lab11Graphs1.WeightedGraph;

import lab11Graphs1.Iterators.MatrixWeightedGraphIterator;
import lab11Graphs1.Iterators.WeightedEdge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AdjacencyMatrixWeightedDigraph implements IWeightedDigraph {
    private ArrayList<ArrayList<Double>> adjList;

    public AdjacencyMatrixWeightedDigraph(int numberOfVertices) {
        adjList = new ArrayList<>(numberOfVertices);

        System.out.println(numberOfVertices);
        for (int i = 0; i < numberOfVertices; i++) {
            ArrayList<Double> curVertex = new ArrayList<>(numberOfVertices);
            if(i%100 == 0) System.out.println(i);
            for (int j = 0; j < numberOfVertices; j++) {
                curVertex.add(Double.POSITIVE_INFINITY);
            }
            adjList.add(curVertex);
        }
    }

    @Override
    public int edgeCount() {
        //doesnt count edge (u, u)
        int sum = 0;
        for (int i = 0; i < adjList.size(); i++) {
            ArrayList<Double> curVertex = adjList.get(i);

            for (int j = 0; j < curVertex.size(); j++) {
                if (curVertex.get(j) != Double.POSITIVE_INFINITY) {
                    sum++;
                }
            }
        }

        return sum;
    }

    @Override
    public int vertexCount() {
        return adjList.size();
    }

    @Override
    public boolean addEdge(int u, int v, double w) {
        if (!vertexInBounds(u) || !vertexInBounds(v)) return false;

        if (!hasEdge(u, v)) {
            adjList.get(u).set(v, w);
            return true;
        }

        return false;
    }

    @Override
    public boolean addEdgeU(int u, int v, double w) {
        if (!vertexInBounds(u) || !vertexInBounds(v)) return false;

        //if there is only one arc return false
        if (!hasEdge(u, v) && !hasEdge(v, u)) {
            return addEdge(u, v, w) && addEdge(v, u, w);
        }
        return false;
    }

    @Override
    public boolean removeEdge(int u, int v) {
        if (vertexInBounds(u) && vertexInBounds(v)) {
            if (weight(u, v) != Double.POSITIVE_INFINITY) {
                adjList.get(u).set(v, Double.POSITIVE_INFINITY);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeEdgeU(int u, int v) {
        boolean removed = removeEdge(u, v);
        if (removeEdge(v, u)) {
            removed = true;
        }
        return removed;
    }

    @Override
    public boolean hasEdge(int u, int v) {
        if (!vertexInBounds(u) || !vertexInBounds(v)) return false;

        return weight(u, v) != Double.POSITIVE_INFINITY;
    }

    private boolean vertexInBounds(int v) {
        return v >= 0 && v < adjList.size();
    }

    @Override
    public boolean hasEdgeU(int u, int v) {
        return hasEdge(u, v) && hasEdge(v, u);
    }

    @Override
    public List<Integer> verticesConnectedTo(int v) {
        List<Integer> vertices = new ArrayList<>();

        List<Double> adjVertices = adjList.get(v);

        for (int i = 0; i < adjVertices.size(); i++) {
            if (adjVertices.get(i) != Double.POSITIVE_INFINITY) {
                vertices.add(i);
            }
        }
        return vertices;
    }

    @Override
    public double weight(int u, int v) {
        if (!vertexInBounds(u) || !vertexInBounds(v)) return Double.POSITIVE_INFINITY;

        return adjList.get(u).get(v);
    }

    @Override
    public void setWeight(int u, int v, double w) {
        if (vertexInBounds(u) && vertexInBounds(v) && adjList.get(u).get(v) != Double.POSITIVE_INFINITY) {
            adjList.get(u).set(v, w);
        }
    }

    @Override
    public Iterator<WeightedEdge> edges(int v) {
        ArrayList<Double> adj = adjList.get(v);

        return new MatrixWeightedGraphIterator(v, adj);
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();
        for (ArrayList<Double> doubles : adjList) {
            returnString.append(doubles.toString()).append("\n");
        }
        return returnString.toString();
    }
}
