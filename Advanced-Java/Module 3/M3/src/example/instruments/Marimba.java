package example.instruments;

public class Marimba extends PitchedPercussion {
    private double numberOfOctaves;
    private boolean barsMissing;

    public Marimba() {
    }

    public Marimba(String brand, String model, int year, boolean playable, String key, String lowestNote, String highestNote, String malletType, double numberOfOctaves, boolean barsMissing) {
        super("Instruments.Marimba", brand, model, year, playable, key, lowestNote, highestNote, false, malletType, "Wood");
        this.numberOfOctaves = numberOfOctaves;
        this.barsMissing = barsMissing;
    }

    public double getNumberOfOctaves() {
        return numberOfOctaves;
    }

    public boolean isBarsMissing() {
        return barsMissing;
    }

    public void setNumberOfOctaves(double numberOfOctaves) {
        this.numberOfOctaves = numberOfOctaves;
    }

    public void setBarsMissing(boolean barsMissing) {
        this.barsMissing = barsMissing;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Number Of Octaves: " + numberOfOctaves +
                "\nkeys Missing? " + barsMissing;
    }

    @Override
    public void determineService() {
        if(getYear() > 2000 && barsMissing == true){
            System.out.println("This Instruments.Marimba needs a few bars replaced.");
        }
    }

    @Override
    public boolean readyToReplace() {
        if(getYear() <= 2000 && barsMissing == true){
            return true;
        }
        return false;
    }
}
