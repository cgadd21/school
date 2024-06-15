/* Cooper Gadd
CSC 101
TThis program will tell you if the number is prime or not.
*/
//import everything needed
import java.util.*;
class PrimeCG{
   public static void main(String[]args){
      //scanner
      Scanner keyboard = new Scanner(System.in);
      //let user know what is happening
      System.out.println("This program will tell you if the number is prime or not.");
      //variable for user input
      int num=0;
      //boolean for while loop
      boolean check=true;
      //while loop
      while(check==true){
         //try to get a positive integer
         try{
         //get the postivie integer
         System.out.println("Please enter a positive integer. Press 0 to quit.");
         num = keyboard.nextInt();
         System.out.println();
         //negative number will throw an exception and have user re-enter num
         if(num<0){
            throw new Exception("Must be a positive value.");
         }
         //quit the loop if user inputs 0
         if(num==0){
            System.out.println("Goodbye.");
            check=false;
         }
         //if user enters positive integer, run through static methods
         else{
            int divCount = getDivisorCount(num);
            boolean prime = isPrime(divCount);
            printResult(prime);
         }
         //catch for not numbers
         }catch (InputMismatchException e){
            System.out.println("Invalid entry. Must be a number.");
            keyboard.nextLine();
         }
         //catch for negative numbers
         catch (Exception e){
            System.out.println(e.getMessage());
            keyboard.nextLine();
         }
      }
   }
   //static method to find the number of divisors and return the number of divisors
   public static int getDivisorCount(int number){
      int count=0;
      for(int i=1; i<=number; i++){
         if(number%i==0){
            count++;
            System.out.println(i);
         }
      }
      return count;
   }
   //static method to see if integer is prime or not, boolean is returned
   public static boolean isPrime(int count){
      if(count==2){
         return true;
      }
      else{
         return false;
      }
   }
   //static method to print the prime or not prime from boolean statement.
   public static void printResult(boolean statement){
      if(statement==true){
         System.out.println("Prime");
      }
      else{
         System.out.println("Not prime.");
      }
   }
    
}