public class Coin extends TreasureItem{
    private int coinValue;
    private String metalType;

    public Coin() {
    }

    public Coin(String itemName, String itemLocation, boolean unique, String use, boolean hidden, int coinValue, String metalType) {
        super(itemName, itemLocation, unique, use, hidden);
        this.coinValue = coinValue;
        this.metalType = metalType;
    }

    public int getCoinValue() {
        return coinValue;
    }

    public void setCoinValue(int coinValue) {
        this.coinValue = coinValue;
    }

    public String getMetalType() {
        return metalType;
    }

    public void setMetalType(String metalType) {
        this.metalType = metalType;
    }

    @Override
    public String toString() {
        return "Coin - Treasure Item\n" + super.toString()
        + "\nCoin Value: " + coinValue
        + "\nMetal Type: " + metalType;
    }

    @Override
    public void activate() {
        System.out.println(getItemName() + " has been activated. You can now spend it.");
    }

    @Override
    public void use() {
        System.out.println(getItemName() + " is in use. Buy something nice for yourself.");
    }

    @Override
    public void expire() {
        System.out.println(getItemName() + " is now expired. The coin can only be spent once.");
    }
}
