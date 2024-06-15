import java.io.Serializable;
//If I remove the interface Serializable, ObjectStreams.java will throw an exception
public class Cat implements Serializable{
    private String name;
    private double weight;
    private int yearBirth;

    public Cat(String name, double weight, int yearBirth) {
        this.name = name;
        this.weight = weight;
        this.yearBirth = yearBirth;
    }

    @Override
    public String toString() {
        return name + " weighs " + weight + " pounds and was born in the year " + yearBirth + ".";
    }
}
