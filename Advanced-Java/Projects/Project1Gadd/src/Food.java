/** This class models a food
 * @author Cooper Gadd
 */
public class Food extends HealthItem{
    /**The lives added from the food
     * */
    private int livesAdded;
    /**If the food is perishable
     * */
    private boolean perishable;
    /**Creates a new food
     * */
    public Food() {
    }
    /**Creates a new food with the given itemName, itemLocation, unique, description, healthValue, livesAdded, and perishable
     * @param itemName the name of the item
     * @param itemLocation the location of the item
     * @param unique determines if the item is unique
     * @param description the use of the item
     * @param healthValue determines if the item is hidden
     * @param livesAdded the lives added from the food
     * @param perishable determines if the food is perishable
     * */
    public Food(String itemName, String itemLocation, boolean unique, String description, int healthValue, int livesAdded, boolean perishable) {
        super(itemName, itemLocation, unique, description, healthValue);
        this.livesAdded = livesAdded;
        this.perishable = perishable;
    }
    /**Gets the lives added from the food
     * @return the lives added form the food
     * */
    public int getLivesAdded() {
        return livesAdded;
    }
    /**Sets the lives added from the food
     * */
    public void setLivesAdded(int livesAdded) {
        this.livesAdded = livesAdded;
    }
    /**Gets the status of perishable for food
     * @return the status of perishable for food
     * */
    public boolean isPerishable() {
        return perishable;
    }
    /**Sets the status of perishable for food
     * */
    public void setPerishable(boolean perishable) {
        this.perishable = perishable;
    }
    /**Override method to display the food's attributes
     * @return the food's attributes printed
     * */
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
    /**Override method to display the food being activated
     * */
    @Override
    public void activate() {
        System.out.println(getItemName() + " has been activated. Enjoy!\n");
    }
    /**Override method to display the food being used
     * */
    @Override
    public void use() {
        System.out.println(getItemName() + " is in use. I hope it is tasty!\n");
    }
    /**Override method to display the food expiring
     * */
    @Override
    public void expire() {
        System.out.println(getItemName() + " is now expired. Please do not eat it!\n");
    }
}
