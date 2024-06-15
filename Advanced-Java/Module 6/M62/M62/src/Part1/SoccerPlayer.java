package Part1;

public class SoccerPlayer extends Athlete {
    private int goals;
    private double shotsPerGoal;

    public SoccerPlayer(){}

    public SoccerPlayer(String name) {
        super(name);
    }

    public SoccerPlayer(String name, int goals, double shotsPerGoal) {
        super(name);
        this.goals = goals;
        this.shotsPerGoal = shotsPerGoal;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public double getShotsPerGoal() {
        return shotsPerGoal;
    }

    public void setShotsPerGoal(double shotsPerGoal) {
        this.shotsPerGoal = shotsPerGoal;
    }

    @Override
    public String toString() {
        return "Soccer Player\n" +
                super.toString() +
                "Goals: " + goals + "\n" +
                "Shots Per Goal: " + shotsPerGoal;
    }
}
