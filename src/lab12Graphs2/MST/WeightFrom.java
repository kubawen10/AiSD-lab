package lab12Graphs2.MST;

public class WeightFrom {
    private double weight;
    private int from;

    public WeightFrom(double weight, int from) {
        this.weight = weight;
        this.from = from;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }
}
