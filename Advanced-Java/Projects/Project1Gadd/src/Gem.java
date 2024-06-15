/** This class models a gem
 * @author Cooper Gadd
 */
public class Gem extends TreasureItem implements Magical{
    /**The color of the gem
     * */
    private String gemColor;
    /**If the gem is valuable
     * */
    private boolean valuable;
    /**Creates a new gem
     * */
    public Gem() {
    }
    /**Creates a new gem with the given itemName, itemLocation, unique, use, hidden, gemColor, and valuable
     * @param itemName the name of the item
     * @param itemLocation the location of the item
     * @param unique determines if the item is unique
     * @param use the use of the item
     * @param hidden determines if the item is hidden
     * @param gemColor the color of the gem
     * @param valuable determines if the gem is valuable
     * */
    public Gem(String itemName, String itemLocation, boolean unique, String use, boolean hidden, String gemColor, boolean valuable) {
        super(itemName, itemLocation, unique, use, hidden);
        this.gemColor = gemColor;
        this.valuable = valuable;
    }
    /**Gets the color of the gem
     * @return the color of the gem
     * */
    public String getGemColor() {
        return gemColor;
    }
    /**Sets the color of the gem
     * */
    public void setGemColor(String gemColor) {
        this.gemColor = gemColor;
    }
    /**Gets the status of valuable
     * @return the status of valuable
     * */
    public boolean isValuable() {
        return valuable;
    }
    /**Sets the status of valuable*/
    public void setValuable(boolean valuable) {
        this.valuable = valuable;
    }
    /**Override method to display the gem's attributes
     * @return the gem's attributes printed
     * */
    @Override
    public String toString() {
        if(!valuable){
            return "Gem - Treasure Item\n" + super.toString()
                    + "\nGem Color: " + gemColor
                    + "\nThis item is not valuable.";
        }
        return "Gem - Treasure Item\n" + super.toString()
                + "\nGem Color: " + gemColor
                + "\nThis item is valuable.";
    }
    /**Override method to display the gem being activated
     * */
    @Override
    public void activate() {
        System.out.println(getItemName() + " has been activated. Prepare for magical things!\n");
    }
    /**Override method to display the gem being used
     * */
    @Override
    public void use() {
        System.out.println(getItemName() + " is in use. This gem will assist you.\n");
    }
    /**Override method to display the gem expiring
     * */
    @Override
    public void expire() {
        System.out.println(getItemName() + " is now expired. The gem can only be used once.\n");
    }
    /**Override method to display the gem granting a wish
     * */
    @Override
    public void grantWish() {
        System.out.println(getItemName() + " has been used to grant a wish.\n");
    }
    /**Override method to display the gem casting a spell
     * */
    @Override
    public void castSpell() {
        System.out.println(getItemName() + " has been used to cast a spell.\n");
    }
}
