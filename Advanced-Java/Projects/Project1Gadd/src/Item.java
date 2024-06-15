public abstract class Item implements Comparable<Item> {
    private String itemName;
    private String itemLocation;
    private boolean unique;

    protected Item() {
    }

    protected Item(String itemName, String itemLocation, boolean unique) {
        this.itemName = itemName;
        this.itemLocation = itemLocation;
        this.unique = unique;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemLocation() {
        return itemLocation;
    }

    public boolean isUnique() {
        return unique;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemLocation(String itemLocation) {
        this.itemLocation = itemLocation;
    }

    public void setUnique(boolean unique) {
        this.unique = unique;
    }

    @Override
    public String toString() {
        if (!unique) {
            return "Item Name: " + itemName + '\n' +
                    "Item Location: " + itemLocation + '\n' +
                    "This item is not unique";
        }
        return "Item Name: " + itemName + '\n' +
                "Item Location: " + itemLocation + '\n' +
                "This item is unique";
    }
    public abstract void activate();

    public abstract void use();

    public abstract void expire();

    @Override
    public int compareTo(Item o) {
        return this.itemName.compareTo(o.getItemName().toLowerCase());
    }
}
