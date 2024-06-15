package Part2;

public class Athlete{
    private String name;

    public Athlete(){}

    public Athlete(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n";

    }
}
