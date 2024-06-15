public abstract class HealthItem extends Item {
    private String description;
    private int healthValue;

    protected HealthItem() {
    }

    protected HealthItem(String itemName, String itemLocation, boolean unique, String description, int healthValue) {
        super(itemName, itemLocation, unique);
        this.description = description;
        this.healthValue = healthValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHealthValue() {
        return healthValue;
    }

    public void setHealthValue(int healthValue) {
        this.healthValue = healthValue;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nDescription: " + description
                + "\nHealth Value: " + healthValue;
    }
}
