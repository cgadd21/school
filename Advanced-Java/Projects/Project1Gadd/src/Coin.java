/** This class models a coin
* @author Cooper Gadd
 */
public class Coin extends TreasureItem{
    /**the coin's value
     * */
    private int coinValue;
    /**the coin's metal type
     * */
    private String metalType;
    /**Creates a new coin
     * */
    public Coin() {
    }
    /**Creates a new coin with the given itemName, itemLocation, unique, use, hidden,coinValue, and metalType
     * @param itemName the name of the item
     * @param itemLocation the location of the item
     * @param unique determines if the item is unique
     * @param use the use of the item
     * @param hidden determines if the item is hidden
     * @param coinValue the value of the coin
     * @param metalType the metal type of the coin
     * */
    public Coin(String itemName, String itemLocation, boolean unique, String use, boolean hidden, int coinValue, String metalType) {
        super(itemName, itemLocation, unique, use, hidden);
        this.coinValue = coinValue;
        this.metalType = metalType;
    }
    /**Gets the value of the coin
     * @return the value of the coin
     * */
    public int getCoinValue() {
        return coinValue;
    }
    /**Sets the value of the coin
     * */
    public void setCoinValue(int coinValue) {
        this.coinValue = coinValue;
    }
    /**Gets the metal type of the coin
     * @return the metal type of the coin
     * */
    public String getMetalType() {
        return metalType;
    }
    /**Sets the metal type of the coin
     * */
    public void setMetalType(String metalType) {
        this.metalType = metalType;
    }
    /**Override method to display the coin's attributes
     * @return the coin's attributes printed
     * */
    @Override
    public String toString() {
        return "Coin - Treasure Item\n" + super.toString()
                + "\nCoin Value: " + coinValue
                + "\nMetal Type: " + metalType;
    }
    /**Override method to display the coin being activated
     * */
    @Override
    public void activate() {
        System.out.println(getItemName() + " has been activated. You can now spend it.\n");
    }
    /**Override method to display the coin being used
     * */
    @Override
    public void use() {
        System.out.println(getItemName() + " is in use. Buy something nice for yourself.\n");
    }
    /**Override method to display the coin expiring
     * */
    @Override
    public void expire() {
        System.out.println(getItemName() + " is now expired. The coin can only be spent once.\n");
    }
}

