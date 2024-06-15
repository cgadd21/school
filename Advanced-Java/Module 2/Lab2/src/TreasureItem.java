public class TreasureItem extends Item{
    private String use;
    private boolean hidden;

    public TreasureItem() {
    }

    public TreasureItem(String itemName, String itemLocation, boolean unique, String use, boolean hidden) {
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

    @Override
    public void activate() {
        super.activate();
    }

    @Override
    public void use() {
        super.use();
    }

    @Override
    public void expire() {
        super.expire();
    }
}
