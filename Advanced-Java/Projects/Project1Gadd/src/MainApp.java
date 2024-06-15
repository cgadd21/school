import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        ArrayList<Item> items=new ArrayList<>();
        Scanner scan=new Scanner(System.in);
        boolean run=true;
        int user;

        while(run){
            System.out.println("""
                    Item Inventory Menu - Enter you selection (1-5)
                    1. View Items
                    2. Add Item
                    3. Remove Item
                    4. Interact with Item
                    5. End Program
                    """);
            user=scan.nextInt();
            scan.nextLine();
            System.out.println();

            if(user<1 || user>5.1){
                System.out.println("Invalid selection. Must be between 1 and 5.\n");

            }else if(user==1){
                if(items.isEmpty()){
                    System.out.println("You have no items.\n");
                }else{
                    Collections.sort(items);
                    for(Item inventory : items){
                        System.out.println(inventory);
                        System.out.println();
                    }
                }

            }else if(user==2){
                int wholeLoop=0;
                while(wholeLoop==0) {
                    System.out.println("""
                            Select an item to add (1-4)
                            1. Coin
                            2. Gem
                            3. Potion
                            4. Food
                            """);
                    user = scan.nextInt();
                    scan.nextLine();
                    System.out.println();
                    if (user < 1 || user > 4.1) {
                        System.out.println("Invalid selection. Must be between 1 and 4.\n");

                    } else if (user == 1) {
                        System.out.println("You selected Coin.\n");

                        System.out.println("What is the item's name?\n");
                        String itemName = scan.nextLine();
                        System.out.println();

                        System.out.println("Where can the item be found?\n");
                        String itemLocation = scan.nextLine();
                        System.out.println();

                        int loop = 0;
                        boolean unique = false;
                        while (loop == 0) {
                            System.out.println("Is the item unique (y/n)? \n");
                            String uniqueAnswer = scan.nextLine();
                            if (Objects.equals(uniqueAnswer.toLowerCase(), "y")) {
                                unique = true;
                                loop = 1;
                            } else if (Objects.equals(uniqueAnswer.toLowerCase(), "n")) {
                                loop = 1;
                            } else {
                                System.out.println("Please enter y/n.\n");
                            }
                            System.out.println();
                        }

                        System.out.println("Provide the use of this item.\n");
                        String use = scan.nextLine();
                        System.out.println();

                        loop = 0;
                        boolean hidden = false;
                        while (loop == 0) {
                            System.out.println("Is this item hidden? (y/n)\n");
                            String hiddenAnswer = scan.nextLine();
                            if (Objects.equals(hiddenAnswer.toLowerCase(), "y")) {
                                hidden = true;
                                loop = 1;
                            } else if (Objects.equals(hiddenAnswer.toLowerCase(), "n")) {
                                loop = 1;
                            } else {
                                System.out.println("Please enter y/n.\n");
                            }
                            System.out.println();
                        }

                        loop = 0;
                        int coinValue = 0;
                        while (loop == 0) {
                            System.out.println("What's this coin's value? (1-100)\n");
                            coinValue = scan.nextInt();
                            scan.nextLine();
                            System.out.println();
                            if (coinValue < 1 || coinValue > 100) {
                                System.out.println("Please enter a valid integer.\n");
                            } else {
                                loop = 1;
                            }
                        }

                        System.out.println("What's this item's metal type?\n");
                        String metalType = scan.nextLine();
                        System.out.println();

                        Coin coin = new Coin(itemName, itemLocation, unique, use, hidden, coinValue, metalType);
                        items.add(coin);
                        System.out.println("Your " + itemName + " has been added.\n");
                        wholeLoop=1;

                    } else if (user == 2) {
                        System.out.println("You selected Gem.\n");

                        System.out.println("What is the item's name?\n");
                        String itemName = scan.nextLine();
                        System.out.println();

                        System.out.println("Where can the item be found?\n");
                        String itemLocation = scan.nextLine();
                        System.out.println();

                        int loop = 0;
                        boolean unique = false;
                        while (loop == 0) {
                            System.out.println("Is the item unique (y/n)? \n");
                            String uniqueAnswer = scan.nextLine();
                            if (Objects.equals(uniqueAnswer.toLowerCase(), "y")) {
                                unique = true;
                                loop = 1;
                            } else if (Objects.equals(uniqueAnswer.toLowerCase(), "n")) {
                                loop = 1;
                            } else {
                                System.out.println("Please enter y/n.\n");
                            }
                            System.out.println();
                        }

                        System.out.println("Provide the use of this item.\n");
                        String use = scan.nextLine();
                        System.out.println();

                        loop = 0;
                        boolean hidden = false;
                        while (loop == 0) {
                            System.out.println("Is this item hidden? (y/n)\n");
                            String hiddenAnswer = scan.nextLine();
                            if (Objects.equals(hiddenAnswer.toLowerCase(), "y")) {
                                hidden = true;
                                loop = 1;
                            } else if (Objects.equals(hiddenAnswer.toLowerCase(), "n")) {
                                loop = 1;
                            } else {
                                System.out.println("Please enter y/n.\n");
                            }
                            System.out.println();
                        }

                        System.out.println("What is this item's color?\n");
                        String gemColor = scan.nextLine();
                        System.out.println();

                        loop = 0;
                        boolean valuable = false;
                        while (loop == 0) {
                            System.out.println("Is this item valuable? (y/n)\n");
                            String valuableAnswer = scan.nextLine();
                            if (Objects.equals(valuableAnswer.toLowerCase(), "y")) {
                                valuable = true;
                                loop = 1;
                            } else if (Objects.equals(valuableAnswer.toLowerCase(), "n")) {
                                loop = 1;
                            } else {
                                System.out.println("Please enter y/n.\n");
                            }
                            System.out.println();
                        }

                        Gem gem = new Gem(itemName, itemLocation, unique, use, hidden, gemColor, valuable);
                        items.add(gem);
                        System.out.println("Your " + itemName + " has been added.\n");
                        wholeLoop=1;

                    } else if (user == 3) {
                        System.out.println("You selected Potion.\n");

                        System.out.println("What is the item's name?\n");
                        String itemName = scan.nextLine();
                        System.out.println();

                        System.out.println("Where can the item be found?\n");
                        String itemLocation = scan.nextLine();
                        System.out.println();

                        int loop = 0;
                        boolean unique = false;
                        while (loop == 0) {
                            System.out.println("Is the item unique (y/n)? \n");
                            String uniqueAnswer = scan.nextLine();
                            if (Objects.equals(uniqueAnswer.toLowerCase(), "y")) {
                                unique = true;
                                loop = 1;
                            } else if (Objects.equals(uniqueAnswer.toLowerCase(), "n")) {
                                loop = 1;
                            } else {
                                System.out.println("Please enter y/n.\n");
                            }
                            System.out.println();
                        }

                        System.out.println("Provide a brief description.\n");
                        String description = scan.nextLine();
                        System.out.println();

                        loop = 0;
                        int healthValue = 0;
                        while (loop == 0) {
                            System.out.println("What is this item's health value? (1-25)\n");
                            healthValue = scan.nextInt();
                            scan.nextLine();
                            System.out.println();
                            if (healthValue < 1 || healthValue > 25) {
                                System.out.println("Please enter a valid integer.\n");
                            } else {
                                loop = 1;
                            }
                        }

                        loop = 0;
                        int duration = 0;
                        while (loop == 0) {
                            System.out.println("What is this item's duration? (1-60)\n");
                            duration = scan.nextInt();
                            scan.nextLine();
                            System.out.println();
                            if (duration < 1 || duration > 60) {
                                System.out.println("Please enter a valid integer.\n");
                            } else {
                                loop = 1;
                            }
                        }

                        loop = 0;
                        double potency = 0;
                        while (loop == 0) {
                            System.out.println("What is this item's potency? (1-100)\n");
                            potency = scan.nextDouble();
                            scan.nextLine();
                            System.out.println();
                            if (potency < 1 || potency > 100) {
                                System.out.println("Please enter a valid double.\n");
                            } else {
                                loop = 1;
                            }
                        }

                        Potion potion = new Potion(itemName, itemLocation, unique, description, healthValue, duration, potency);
                        items.add(potion);
                        System.out.println("Your " + itemName + " has been added.\n");
                        wholeLoop=1;

                    } else if (user == 4) {
                        System.out.println("You selected Food.\n");

                        System.out.println("What is the item's name?\n");
                        String itemName = scan.nextLine();
                        System.out.println();

                        System.out.println("Where can the item be found?\n");
                        String itemLocation = scan.nextLine();
                        System.out.println();

                        int loop = 0;
                        boolean unique = false;
                        while (loop == 0) {
                            System.out.println("Is the item unique (y/n)? \n");
                            String uniqueAnswer = scan.nextLine();
                            if (Objects.equals(uniqueAnswer.toLowerCase(), "y")) {
                                unique = true;
                                loop = 1;
                            } else if (Objects.equals(uniqueAnswer.toLowerCase(), "n")) {
                                loop = 1;
                            } else {
                                System.out.println("Please enter y/n.\n");
                            }
                            System.out.println();
                        }

                        System.out.println("Provide a brief description.\n");
                        String description = scan.nextLine();
                        System.out.println();

                        loop = 0;
                        int healthValue = 0;
                        while (loop == 0) {
                            System.out.println("What is this item's health value? (1-25)\n");
                            healthValue = scan.nextInt();
                            scan.nextLine();
                            System.out.println();
                            if (healthValue < 1 || healthValue > 25) {
                                System.out.println("Please enter a valid integer.\n");
                            } else {
                                loop = 1;
                            }
                        }

                        loop = 0;
                        int livesAdded = 0;
                        while (loop == 0) {
                            System.out.println("How many extra lives given by food item? (1-5)\n");
                            livesAdded = scan.nextInt();
                            scan.nextLine();
                            System.out.println();
                            if (livesAdded < 1 || livesAdded > 5) {
                                System.out.println("Please enter a valid integer.\n");
                            } else {
                                loop = 1;
                            }
                        }

                        loop = 0;
                        boolean perishable = false;
                        while (loop == 0) {
                            System.out.println("Does this food perish quickly? (y/n)\n");
                            String perishableAnswer = scan.nextLine();
                            if (Objects.equals(perishableAnswer.toLowerCase(), "y")) {
                                perishable = true;
                                loop = 1;
                            } else if (Objects.equals(perishableAnswer.toLowerCase(), "n")) {
                                loop = 1;
                            } else {
                                System.out.println("Please enter y/n.\n");
                            }
                            System.out.println();
                        }

                        Food food = new Food(itemName, itemLocation, unique, description, healthValue, livesAdded, perishable);
                        items.add(food);
                        System.out.println("Your " + itemName + " has been added.\n");
                        wholeLoop=1;
                    }
                }
            }else if(user==3){

                if(items.isEmpty()){
                    System.out.println("You have no items.\n");
                }else {
                    System.out.println("Please provide the name of the item you'd like to remove.\n");
                    String nameToRemove = scan.nextLine().toLowerCase();
                    System.out.println();
                    boolean nameInInventory = false;
                    for (int i = 0; i < items.size(); i++) {
                        String itemName = items.get(i).getItemName();
                        itemName = itemName.toLowerCase();
                        if (nameToRemove.equals(itemName)) {
                            items.remove(i);
                            System.out.println(itemName + " has been removed from your inventory.\n");
                            nameInInventory = true;
                        }
                    }
                    if (!nameInInventory) {
                        System.out.println("This item is not in your inventory.\n");
                    }
                }
            }else if(user==4){

                if(items.isEmpty()){
                    System.out.println("You have no items.\n");
                }else{
                    for (int i = 0; i < items.size(); i++) {
                        System.out.println((i + 1) + ". " + items.get(i).getItemName());
                    }
                    int loop = 0;
                    int innerLoop = 0;
                    while (loop == 0) {
                        System.out.println("Which item would you like to interact with? Enter the number.\n");
                        int interactNumber = scan.nextInt();
                        scan.nextLine();
                        if (interactNumber > items.size()) {
                            System.out.println("Please enter a valid integer.\n");
                        } else if (items.get(interactNumber - 1) instanceof Coin || items.get(interactNumber - 1) instanceof Food) {
                            while (innerLoop == 0) {
                                System.out.println("Which action would you like to perform?\n");
                                System.out.println("""
                                        1. Activate Item
                                        2. Use Item
                                        3. Expire Item
                                        """);
                                int actionNumber = scan.nextInt();
                                scan.nextLine();
                                if (actionNumber < 0 || actionNumber > 3.1) {
                                    System.out.println("Please enter a valid action to perform.\n");
                                } else if (actionNumber == 1) {
                                    items.get(interactNumber - 1).activate();
                                    innerLoop = 1;
                                } else if (actionNumber == 2) {
                                    items.get(interactNumber - 1).use();
                                    innerLoop = 1;
                                } else if (actionNumber == 3) {
                                    items.get(interactNumber - 1).expire();
                                    innerLoop = 1;
                                }
                            }
                            loop = 1;
                        } else if (items.get(interactNumber - 1) instanceof Gem tempGem) {
                            while (innerLoop == 0) {
                                System.out.println("Which action would you like to perform?\n");
                                System.out.println("""
                                        1. Activate Item
                                        2. Use Item
                                        3. Expire Item
                                        4. Grant a Wish
                                        5. Cast Spell
                                        """);
                                int actionNumber = scan.nextInt();
                                scan.nextLine();
                                if (actionNumber < 0 || actionNumber > 5.1) {
                                    System.out.println("Please enter a valid action to perform.\n");
                                } else if (actionNumber == 1) {
                                    items.get(interactNumber - 1).activate();
                                    innerLoop = 1;
                                } else if (actionNumber == 2) {
                                    items.get(interactNumber - 1).use();
                                    innerLoop = 1;
                                } else if (actionNumber == 3) {
                                    items.get(interactNumber - 1).expire();
                                    innerLoop = 1;
                                } else if (actionNumber == 4) {
                                    tempGem.grantWish();
                                    innerLoop = 1;
                                } else if (actionNumber == 5) {
                                    tempGem.castSpell();
                                    innerLoop = 1;
                                }
                            }
                            loop = 1;
                        } else if (items.get(interactNumber - 1) instanceof Potion tempPotion) {
                            while (innerLoop == 0) {
                                System.out.println("Which action would you like to perform?\n");
                                System.out.println("""
                                        1. Activate Item
                                        2. Use Item
                                        3. Expire Item
                                        4. Grant a Wish
                                        5. Cast Spell
                                        """);
                                int actionNumber = scan.nextInt();
                                scan.nextLine();
                                if (actionNumber < 0 || actionNumber > 5.1) {
                                    System.out.println("Please enter a valid action to perform.\n");
                                } else if (actionNumber == 1) {
                                    items.get(interactNumber - 1).activate();
                                    innerLoop = 1;
                                } else if (actionNumber == 2) {
                                    items.get(interactNumber - 1).use();
                                    innerLoop = 1;
                                } else if (actionNumber == 3) {
                                    items.get(interactNumber - 1).expire();
                                    innerLoop = 1;
                                } else if (actionNumber == 4) {
                                    tempPotion.grantWish();
                                    innerLoop = 1;
                                } else if (actionNumber == 5) {
                                    tempPotion.castSpell();
                                    innerLoop = 1;
                                }
                            }
                            loop = 1;
                        }
                    }
                }
            }else if(user==5){
                int coinCount=0;
                int gemCount=0;
                int potionCount=0;
                int foodCount=0;
                System.out.println("The list currently contains:\n");
                for (Item item : items) {
                    if (item instanceof Coin) {
                        coinCount += 1;
                    } else if (item instanceof Gem) {
                        gemCount += 1;
                    } else if (item instanceof Potion) {
                        potionCount += 1;
                    } else if (item instanceof Food) {
                        foodCount += 1;
                    }
                }
                System.out.println(coinCount + " Coin(s)\n" + gemCount + " Gem(s)\n" + potionCount + " Potion(s)\n" + foodCount + " Food Item(s)\n");
                System.out.println("Goodbye.\n");
                run=false;
            }

        }

    }

}
