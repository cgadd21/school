/** This class models a potion
 * @author Cooper Gadd
 */
public class Potion extends HealthItem implements Magical{
    /**The duration of the potion
     * */
    private int duration;
    /**The potency of the potion
     * */
    private double potency;
    /**Creates a new potion
     * */
    public Potion() {
    }
    /**Creates a new potion with the given itemName, itemLocation, unique, description, healthValue, duration, and potency
     * @param itemName the name of the item
     * @param itemLocation the location of the item
     * @param unique determines if the item is unique
     * @param description the use of the item
     * @param healthValue determines if the item is hidden
     * @param duration the duration of the potion
     * @param potency the duration of the potion
     * */
    public Potion(String itemName, String itemLocation, boolean unique, String description, int healthValue, int duration, double potency) {
        super(itemName, itemLocation, unique, description, healthValue);
        this.duration = duration;
        this.potency = potency;
    }
    /**Gets the duration of the potion
     * @return the duration of the potion
     * */
    public int getDuration() {
        return duration;
    }
    /**Sets the duration of the potion
     * */
    public void setDuration(int duration) {
        this.duration = duration;
    }
    /**Gets the potency of the potion
     * @return the potency of the potion
     * */
    public double getPotency() {
        return potency;
    }
    /**Sets the potency of the potion
     * */
    public void setPotency(double potency) {
        this.potency = potency;
    }
    /**Override method to display the potion's attributes
     * @return the potion's attributes printed
     * */
    @Override
    public String toString() {
        return "Potion - Health Item\n" + super.toString()
                + "\nDuration: " + duration
                + "\nPotency: " + potency;
    }
    /**Override method to display the potion being activated
     * */
    @Override
    public void activate() {
        System.out.println(getItemName() + " has been activated. Time to drink up!\n");
    }
    /**Override method to display the potion being used
     * */
    @Override
    public void use() {
        System.out.println(getItemName() + " is in use. I hope this is a good potion!\n");
    }
    /**Override method to display the potion expiring
     * */
    @Override
    public void expire() {
        System.out.println(getItemName() + " is now expired. Don't drink this potion!\n");
    }
    /**Override method to display the potion granting a wish
     * */
    @Override
    public void grantWish() {
        System.out.println(getItemName() + " has been used to grant a wish.\n");
    }
    /**Override method to display the potion casting a spell
     * */
    @Override
    public void castSpell() {
        System.out.println(getItemName() + " has been used to cast a spell.\n");
    }
}
