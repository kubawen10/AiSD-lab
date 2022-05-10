package lab9HeapyBST.Testing;

public class Result {
    private double avgTime;
    private double timeStdDev;

    public Result(double avgTime, double timeStdDev) {
        this.avgTime = avgTime;
        this.timeStdDev = timeStdDev;
    }

    public double getAvgTime() {
        return avgTime;
    }

    public void setAvgTime(double avgTime) {
        this.avgTime = avgTime;
    }

    public double getTimeStdDev() {
        return timeStdDev;
    }

    public void setTimeStdDev(double timeStdDev) {
        this.timeStdDev = timeStdDev;
    }

    public String toString(){
        return String.format("Avg time: %.2f Std Dev: %.2f", avgTime, timeStdDev);
    }
}
