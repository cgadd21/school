package Part1;

public class FootballPlayer extends Athlete {
    private int touchdowns;
    private int interceptions;

    public FootballPlayer(){}

    public FootballPlayer(String name) {
        super(name);
    }

    public FootballPlayer(String name, int touchdowns, int interceptions) {
        super(name);
        this.touchdowns = touchdowns;
        this.interceptions = interceptions;
    }

    public int getTouchdowns() {
        return touchdowns;
    }

    public void setTouchdowns(int touchdowns) {
        this.touchdowns = touchdowns;
    }

    public int getInterceptions() {
        return interceptions;
    }

    public void setInterceptions(int interceptions) {
        this.interceptions = interceptions;
    }

    @Override
    public String toString() {
        return "Football Player\n" +
                super.toString() +
                "Touchdowns: " + touchdowns + "\n" +
                "Interceptions: " + interceptions;
    }
}
