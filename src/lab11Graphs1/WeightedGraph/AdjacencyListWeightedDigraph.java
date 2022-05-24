package lab11Graphs1.WeightedGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class AdjacencyListWeightedDigraph implements IWeightedDigraph {
    class WeightedArc {
        int toVertex;
        double weight;

        WeightedArc(int toVertex, double weight) {
            this.toVertex = toVertex;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            WeightedArc that = (WeightedArc) o;
            return toVertex == that.toVertex;
        }

        @Override
        public String toString() {
            return "(to: " + toVertex + " w: " + weight + ")";
        }
    }

    private ArrayList<LinkedList<WeightedArc>> adjList;

    public AdjacencyListWeightedDigraph(int numberOfVertices) {
        adjList = new ArrayList<>(numberOfVertices);

        for (int i = 0; i < numberOfVertices; i++) {
            adjList.add(new LinkedList<>());
        }
    }

    @Override
    public int edgeCount() {
        int sum = 0;
        for (int i = 0; i < adjList.size(); i++) {
            sum += adjList.get(i).size();
        }

        return sum;
    }

    @Override
    public int vertexCount() {
        return adjList.size();
    }

    @Override
    public boolean addEdge(int u, int v, double w) {
        if (u == v || !vertexInBounds(u) || !vertexInBounds(v)) return false;

        if (!hasEdge(u, v)) {
            adjList.get(u).add(new WeightedArc(v, w));
            return true;
        }
        return false;
    }

    @Override
    public boolean addEdgeU(int u, int v, double w) {
        if(!vertexInBounds(u) || !vertexInBounds(v)) return false;

        //if there is only one arc return false
        if (!hasEdge(u, v) && !hasEdge(v, u)) {
            return addEdge(u, v, w) && addEdge(v, u, w);
        }
        return false;
    }

    @Override
    public boolean removeEdge(int u, int v) {
        if (vertexInBounds(u) && vertexInBounds(v)) {
            return adjList.get(u).remove(new WeightedArc(v, 0));
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
        if (u == v) return true;

        if (!vertexInBounds(u) || !vertexInBounds(v)) return false;

        WeightedArc arc = new WeightedArc(v, 0);
        return adjList.get(u).contains(arc);
    }

    //ensures that v is proper vertex number
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

        List<WeightedArc> adjVertices = adjList.get(v);

        for (WeightedArc adjVertex : adjVertices) {
            vertices.add(adjVertex.toVertex);
        }

        return vertices;
    }

    @Override
    public double weight(int u, int v) {
        if (u == v) return 0;

        WeightedArc arc = getArc(u, v);

        if (arc != null) {
            return arc.weight;
        }

        return Double.POSITIVE_INFINITY;
    }

    @Override
    public void setWeight(int u, int v, double w) {
        WeightedArc arc = getArc(u, v);

        if (arc != null) {
            arc.weight = w;
        }
    }

    private WeightedArc getArc(int u, int v) {
        if (vertexInBounds(u) && vertexInBounds(v)) {
            LinkedList<WeightedArc> arcs = adjList.get(u);
            WeightedArc arc = new WeightedArc(v, 0);
            int index = arcs.indexOf(arc);

            if (index >= 0) {
                return arcs.get(index);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();

        for (LinkedList<WeightedArc> weightedArcs : adjList) {
            returnString.append(weightedArcs.toString()).append("\n");
        }
        return returnString.toString();
    }
}
