import java.text.DecimalFormat;
import java.util.*;
class Converter{
   public static void main(String[]args){
      DecimalFormat two = new DecimalFormat("0.00");
      Scanner keyboard = new Scanner(System.in);
      System.out.println("This program will convert units of measurement.");
      boolean check = true;
      while(check == true){
         printMenu();
         int choice = keyboard.nextInt();
         
         if (choice ==1){
            System.out.println("Enter your number in kilometers: ");
            double km = getGoodDouble();
            double convertedKm = convertToMiles(km);
            System.out.println("This is equal to "+two.format(convertedKm)+" miles.");
         }
         else if (choice ==2){
            System.out.println("Enter your number in miles: ");
            double mi = getGoodDouble();
            double convertedMi = convertToKm(mi);
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
   public static void printMenu(){
         System.out.println("Select 1, 2, or 3.");
         System.out.println("1. km to miles");
         System.out.println("2. miles to km");
         System.out.println("3. exit the program");   
   }
   public static double convertToMiles(double kilometers){
      return kilometers / 1.609;
   }
   public static double convertToKm(double miles){
      return miles * 1.609;
   }
   public static double getGoodDouble(){
      Scanner scanner = new Scanner(System.in);
      double num = 0;
      boolean check = true; 
      while(check==true){
      try{
         num = scanner.nextDouble();
         if (num<0){
               throw new Exception("Value must be positive.");
         }
         check=false;
         }
         catch (InputMismatchException e){
            System.out.println("Invalid entry. Must be a number.");
            scanner.nextLine();
         }
         catch(Exception e){
            System.out.println(e.getMessage());
            scanner.nextLine();
         }
         
      }
      return num;
   }
}