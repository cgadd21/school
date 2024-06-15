public abstract class TreasureItem extends Item{
    private String use;
    private boolean hidden;

    protected TreasureItem() {
    }

    protected TreasureItem(String itemName, String itemLocation, boolean unique, String use, boolean hidden) {
        super(itemName, itemLocation, unique);
        this.use = use;
        this.hidden = hidden;
    }

    public String getUse() {
        return use;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    @Override
    public String toString() {
        if(!hidden){
            return super.toString()
                    + "\nUsage: "  + use
                    +"\nThis is not a hidden item.";
        }
        return super.toString()
                + "\nUsage: "  + use
                +"\nThis is a hidden item.";
    }
}
