package CompExample;

public class Tomato{
    private String variety;
    private String type;
    private String color;
    private boolean indeterminate;
    private int daysToGerminate;
    private int daysToHarvest;

    public Tomato() {
    }

    public Tomato(String variety) {
        this.variety = variety;
    }

    public Tomato(String variety, String type, String color, boolean indeterminate, int daysToGerminate, int daysToHarvest) {
        this.variety = variety;
        this.type = type;
        this.color = color;
        this.indeterminate = indeterminate;
        this.daysToGerminate = daysToGerminate;
        this.daysToHarvest = daysToHarvest;
    }


    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isIndeterminate() {
        return indeterminate;
    }

    public void setIndeterminate(boolean indeterminate) {
        this.indeterminate = indeterminate;
    }

    public int getDaysToGerminate() {
        return daysToGerminate;
    }

    public void setDaysToGerminate(int daysToGerminate) {
        this.daysToGerminate = daysToGerminate;
    }

    public int getDaysToHarvest() {
        return daysToHarvest;
    }

    public void setDaysToHarvest(int daysToHarvest) {
        this.daysToHarvest = daysToHarvest;
    }

    @Override
    public String toString() {
        return "CompExample.Tomato{" +
                "variety='" + variety + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", indeterminate=" + indeterminate +
                ", daysToGerminate=" + daysToGerminate +
                ", daysToHarvest=" + daysToHarvest +
                "}\n";
    }
}
