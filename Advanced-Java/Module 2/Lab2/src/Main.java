import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Item> myItems = new ArrayList<>();
        myItems.add(new Food("Pie", "The Forest", false, "a slice of cherry pie", 10, 1, true));
        myItems.add(new Potion("Elixir of Joy", "Level 5 Castle", true, "gives receiver power", 20, 60, 1.0));
        myItems.add(new Coin("Tiny Token", "All Locations", false, "purchase supplies", false, 15, "Silver"));
        myItems.add(new Gem("Dazzling Diamond", "final level castle", true, "purchases passage onto ship", true, "clear", true));

        System.out.println("Your Inventory:");
        for(int i = 0; i < myItems.size(); i++){
            System.out.print((i+1) + ". ");
            System.out.println(myItems.get(i));
            System.out.println();
        }

        System.out.println("Testing Actions...");
        for(Item item: myItems){
            item.activate();
            item.use();
            item.expire();
            System.out.println();
        }

        System.out.println("Testing Setters...");
        System.out.println("Updating all names to add \"New and Improved\" in front of the original name...");
        System.out.println("Background process... nothing to see here.");
        for(int i = 0; i < myItems.size(); i++){
            myItems.get(i).setItemName("New and Improved " + myItems.get(i).getItemName());
        }

        System.out.println();
        System.out.println("Testing Getters...");
        System.out.println("Getting names and locations of all items...");
        for(Item item: myItems){
            System.out.println(item.getItemName() + " --> " + item.getItemLocation());
        }


    }
}
