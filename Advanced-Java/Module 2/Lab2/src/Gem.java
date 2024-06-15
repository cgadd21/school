public class Gem extends TreasureItem{
    private String gemColor;
    private boolean valuable;

    public Gem() {
    }

    public Gem(String itemName, String itemLocation, boolean unique, String use, boolean hidden, String gemColor, boolean valuable) {
        super(itemName, itemLocation, unique, use, hidden);
        this.gemColor = gemColor;
        this.valuable = valuable;
    }

    public String getGemColor() {
        return gemColor;
    }

    public void setGemColor(String gemColor) {
        this.gemColor = gemColor;
    }

    public boolean isValuable() {
        return valuable;
    }

    public void setValuable(boolean valuable) {
        this.valuable = valuable;
    }

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

    @Override
    public void activate() {
        System.out.println(getItemName() + " has been activated. Prepare for magical things!");
    }

    @Override
    public void use() {
        System.out.println(getItemName() + " is in use. This gem will assist you.");
    }

    @Override
    public void expire() {
        System.out.println(getItemName() + " is now expired. The gem can only be used once.");
    }
}
