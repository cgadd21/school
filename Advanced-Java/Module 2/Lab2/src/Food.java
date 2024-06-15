public class Food extends HealthItem{
    private int livesAdded;
    private boolean perishable;

    public Food() {
    }

    public Food(String itemName, String itemLocation, boolean unique, String description, int healthValue, int livesAdded, boolean perishable) {
        super(itemName, itemLocation, unique, description, healthValue);
        this.livesAdded = livesAdded;
        this.perishable = perishable;
    }

    public int getLivesAdded() {
        return livesAdded;
    }

    public void setLivesAdded(int livesAdded) {
        this.livesAdded = livesAdded;
    }

    public boolean isPerishable() {
        return perishable;
    }

    public void setPerishable(boolean perishable) {
        this.perishable = perishable;
    }

    @Override
    public String toString() {
        if(!perishable){
            return "Food - Health Item\n" + super.toString()
                    + "\nLives Added: " + livesAdded
                    + "\nThis item is not perishable.";
        }
            return "Food - Health Item\n" +super.toString()
                    + "\nLives Added: " + livesAdded
                    + "\nThis item is perishable.";
    }

    @Override
    public void activate() {
        System.out.println(getItemName() + " has been activated. Enjoy!");
    }

    @Override
    public void use() {
        System.out.println(getItemName() + " is in use. I hope it is tasty!");
    }

    @Override
    public void expire() {
        System.out.println(getItemName() + " is now expired. Please do not eat it!");
    }
}
