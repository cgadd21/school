package example.instruments;

public class SnareDrum extends NonPitchedPercussion {
    private double diameter;
    private double depth;
    private int headCondition;

    public SnareDrum() {
    }

    public SnareDrum(String brand, String model, int year, boolean playable, String strikerType, String surfaceType, boolean orchestral, double diameter, double depth, int headCondition) {
        super("Snare Drum", brand, model, year, playable, strikerType, surfaceType, orchestral);
        this.diameter = diameter;
        this.depth = depth;
        this.headCondition = headCondition;
    }

    public double getDiameter() {
        return diameter;
    }

    public double getDepth() {
        return depth;
    }

    public int getHeadCondition(){
        return headCondition;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public void setHeadCondition(int headCondition){
        this.headCondition = headCondition;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Diameter: " + diameter + " inches; Depth: " + depth + " inches" +
                "\nHead Condition: " + headCondition;

    }

    @Override
    public void determineService() {
        if(headCondition < 5){
            System.out.println("It's time to replace the drum head.");
        }
    }

    @Override
    public boolean readyToReplace() {
        if(getYear() < 1990){
            return true;
        }
        return false;
    }
}
