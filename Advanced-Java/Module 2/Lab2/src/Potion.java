public class Potion extends HealthItem{
    private int duration;
    private double potency;

    public Potion() {
    }

    public Potion(String itemName, String itemLocation, boolean unique, String description, int healthValue, int duration, double potency) {
        super(itemName, itemLocation, unique, description, healthValue);
        this.duration = duration;
        this.potency = potency;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getPotency() {
        return potency;
    }

    public void setPotency(double potency) {
        this.potency = potency;
    }

    @Override
    public String toString() {
        return "Potion - Health Item\n" + super.toString()
        + "\nDuration: " + duration
        + "\nPotency: " + potency;
    }

    @Override
    public void activate() {
        System.out.println(getItemName() + " has been activated. Time to drink up!");
    }

    @Override
    public void use() {
        System.out.println(getItemName() + " is in use. I hope this is a good potion!");
    }

    @Override
    public void expire() {
        System.out.println(getItemName() + " is now expired. Don't drink this potion!");
    }
}
