package lab11Graphs1.Iterators;

public class WeightedEdge implements Comparable<WeightedEdge> {
    public final int beginning;
    public final int end;
    public final double weight;

    public WeightedEdge(int beginning, int end, double weight) {
        this.beginning = beginning;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return beginning + " " + end + " " + weight;
    }

    @Override
    public int compareTo(WeightedEdge o) {
        //firstly compare by weight
        if (weight != o.weight) {
            return Double.compare(weight, o.weight);
        }

        //secondly compare by beginning vertex
        if(beginning != o.beginning){
            return Integer.compare(beginning, o.beginning);
        }

        //lastly compare by ending vertex
        return Integer.compare(end, o.end);
    }
}