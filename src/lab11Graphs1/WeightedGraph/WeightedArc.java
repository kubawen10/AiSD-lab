package lab11Graphs1.WeightedGraph;

public class WeightedArc {
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

    public int getToVertex() {
        return toVertex;
    }

    public double getWeight() {
        return weight;
    }
}
