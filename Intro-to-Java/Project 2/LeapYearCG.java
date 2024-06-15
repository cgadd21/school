/* Cooper Gadd
CSC 101
This program will ask the user for a year and tell them if its a leap year or not.
*/
//import everything needed
import java.util.*;
class LeapYearCG{
   public static void main(String[]args){
      //scanner      
      Scanner keyboard = new Scanner(System.in);
      //variable for user's number
      int year;
      //set boolean variable to true for while loop to run
      boolean check = true;
      //while loop
      while(check == true){
         //tell user what to enter into program
         System.out.println("Enter a 4-digit year to see if it's a leap year or 0 to exit.");
         //assign year to what user enters
         year = keyboard.nextInt();
         //if year is negative tell user and ask for a positive one
         if(year<0){
            System.out.println("Invalid Input. Enter a positive number.");
         }
         //if year is 0 exit program
         else if(year==0){
            check = false;
            System.out.println("Goodbye.");
         }
         //year is a leap year if the year is divisible by 4, but not divisible by 100 unless it is also divisible by 100
         else if(year%4==0 && year%100!=0 || year%400==0){
            System.out.println("This is a leap year.");
         }
         //if the requirements are not met then the number the user entered is not a leap year
         else{
            System.out.println("This is not a leap year.");
         }

      }
   }
}