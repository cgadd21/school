/* Cooper Gadd
CSC 101
This program is a pet adoption for a shelter owner.
*/
//import
import java.util.*;
import java.text.DecimalFormat;
//class
class MainApp{
   //main method
   public static void main(String args[]){
      //welcoming message
      System.out.println("Welcome to Cooper's Adoption Center!");
      System.out.println("");
      //scanner
      Scanner scan = new Scanner(System.in);
      //decimal format
      DecimalFormat two = new DecimalFormat("0.00");
      //create array of 6 Pet objects
      Pet[] pets=new Pet[6];
      //setting values for the 6 Pet objects
      pets[0]=new Pet("Jon",5,99.99,true);
      pets[1]=new Pet("Shadow",55,45.00,true);
      pets[2]=new Pet("Betsy",24,75.00,false);
      pets[3]=new Pet("Petunia",11,81.00,false);
      pets[4]=new Pet("Taco",99,25.00,true);
      pets[5]=new Pet("Marcia",49,75.00,false);
      //boolean for the while loop
      boolean check=true;
      //while loop to keep going until user does not want to continue
      while(check==true){
         //print the menu
         System.out.println("1. View all pet information");
         System.out.println("2. Update pet name");
         System.out.println("3. See all pets not yet sprayed/ neutered");
         System.out.println("4. See all pets under twelve months");
         System.out.println("5. Apply adoption discount");
         System.out.println("6. Exit");
         //get the user's choice and assign it to choice
         int choice = scan.nextInt();
         //clear the buffer
         scan.nextLine();
         //if user selects option 1
         if (choice ==1){
            //go through the whole array of Pet
            for(int i=0; i<pets.length; i++){
               //print the getDescription for each object
               System.out.println(pets[i].getDescription());
            }
         }
         //if user selects option 2
         else if (choice ==2){
            //ask user which pet name they would like to update
            System.out.println("Which pet's name would you like to update?");
            //take user response and assign it to petName
            String petName=scan.next();
            //clear the buffer
            scan.nextLine();
            //boolean to check if the pet exists
            boolean exist=false;
            //loops to go through the whole array of Pet
            for(int i=0; i<pets.length; i++){
               //if the pet name the user entered is one of the names in the array
               if(petName.equals(pets[i].getName())){
                  //user pet is in pet array
                  exist=true;
                  //ask user what name they would like to replace
                  System.out.println("What name would you like to update it with?");
                  //store replacement name in replaceName
                  String replaceName=scan.next();
                  //clear the buffer
                  scan.nextLine();
                  //user updateName to replace the original name with the replacement name
                  pets[i].updateName(replaceName);
                  //let the user know that it worked
                  System.out.println(petName+" has been updated with "+replaceName);
               }
            }
            //user name is not in array
            if(exist==false){
               //let the user know
               System.out.println(petName+" not found.");
            } 
         }
         //if user selects option 3
         else if (choice ==3){
            //go through array
            for(int i=0; i<pets.length; i++){
               //if the pet is spayed or neutered
               if(pets[i].isStatus()==false){
                  //print the name if the sprayed or neutered pets
                  System.out.println(pets[i].getName());
               }
            }
         }
         //if user selects option 4
         else if (choice ==4){
            //go through array
            for(int i=0; i<pets.length; i++){
               //if the pet is under 12 months
               if(pets[i].isBaby()==true){
                  //print the names of the pets that are under 12 months
                  System.out.println(pets[i].getName());
               }
            }
         }
         //if user selects option 5
         else if (choice ==5){
            //ask user what the discount should be
            System.out.println("What discount should be applied? (.15, .25, etc)");
            //assign the user's input to discount
            double discount=scan.nextDouble();
            //clear the buffer
            scan.nextLine();
            //go through array
            for(int i=0; i<pets.length; i++){
               //display the pet's name and the discounted price of each animal in array
               System.out.println(pets[i].getName()+": $"+two.format(pets[i].applyDiscount(pets[i].getFee(), discount)));
            }
         }
         //if user selects option 6
         else if (choice ==6){
            //inform the user the program is done
            System.out.println("Goodbye!");
            //end the while loop
            check=false;
         }
         //if the user does not input 1-6
         else{
            //display that the user entered incorrect input
            System.out.println("Please enter a valid number.");
         }
      }
   }
}