package Part2;

public class BaseballPlayer extends Athlete {
    private double battingAvg;
    private double homeRuns;

    public BaseballPlayer() { }

    public BaseballPlayer(String name) {
        super(name);
    }

    public BaseballPlayer(String name, double battingAvg, double homeRuns) {
        super(name);
        this.battingAvg = battingAvg;
        this.homeRuns = homeRuns;
    }

    public double getBattingAvg() {
        return battingAvg;
    }

    public void setBattingAvg(double battingAvg) {
        this.battingAvg = battingAvg;
    }

    public double getHomeRuns() {
        return homeRuns;
    }

    public void setHomeRuns(double homeRuns) {
        this.homeRuns = homeRuns;
    }

    @Override
    public String toString() {
        return "Baseball Player\n" +
                super.toString() +
                "Batting Average: " + battingAvg + "\n" +
                "Home Runs: " + homeRuns;
    }
}
