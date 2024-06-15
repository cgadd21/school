import java.util.Scanner;

public class BeverageTracker {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Beverage[] myFavorites = new Beverage[4];

        myFavorites[0] = new Beverage("Tea", "Black Tea", 0, true);
        myFavorites[1] = new Beverage("Apple Juice", "Fruit Juice from Apples", 120, false);
        myFavorites[2] = new Beverage("Red Bull", "Energy Drink", 168, true);
        myFavorites[3] = new Beverage("Hawaiian Punch", "Sugary, Fruitless Red Drink", 200, false);

        System.out.println("Beverage Information:");
        for (Beverage myFavorite : myFavorites) {
            //Assigning message its contents (if the get calories is less than 120 then set low to the string message)
            String message = myFavorite.getCalories() <= 120 ? "low" : "high";
            System.out.println(myFavorite);
            //The print statement is formatted with inserting the String (message) into the "%s"
            System.out.printf("This is a %s calorie beverage.\n", message);
        }
        System.out.println();

        System.out.println("A list of non-caffeinated beverages:");
        for (Beverage myFavorite : myFavorites) {
            if (!myFavorite.isCaffeinated()) {
                System.out.println(myFavorite.getName());
            }
        }
        System.out.println("What type of beverage would you like to search for?");
        String input = scanner.nextLine();
        boolean noBev = true;
        for (Beverage myFavorite : myFavorites) {
            if (myFavorite.getDescription().toLowerCase().contains(input.toLowerCase())) {
                System.out.println(myFavorite.getName());
                noBev = false;
        }
        }
        if (noBev){
            System.out.println("No beverage found");
        }
    }

}
