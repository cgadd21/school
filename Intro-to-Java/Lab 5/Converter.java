import java.text.DecimalFormat;
import java.util.*;
class Converter{
   public static void main(String[]args){
      DecimalFormat two = new DecimalFormat("0.00");
      Scanner keyboard = new Scanner(System.in);
      Scanner scan = new Scanner(System.in);
      System.out.println("This program will convert units of measurement.");
      boolean check = true;
      while(check == true){
         System.out.println("Select 1, 2, or 3.");
         System.out.println("1. km to miles");
         System.out.println("2. miles to km");
         System.out.println("3. exit the program");
         int choice = keyboard.nextInt();
         
         if (choice ==1){
            System.out.println("Enter your number in kilometers: ");
            double km = scan.nextDouble();
            double convertedKm = km / 1.609;
            System.out.println("This is equal to "+two.format(convertedKm)+" miles.");
         }
         else if (choice ==2){
            System.out.println("Enter your number in miles: ");
            double mi = scan.nextDouble();
            double convertedMi = mi * 1.609;
            System.out.println("This is equal to "+two.format(convertedMi)+" kilometers.");
         }
         else if (choice ==3){
            check = false;
            System.out.println("Goodbye!");
         }
         else{
            System.out.println("Please enter valid number.");
         }     
   }
   }
}