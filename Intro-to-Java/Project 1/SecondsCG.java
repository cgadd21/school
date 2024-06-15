/* Cooper Gadd
CSC 101
This program will ask the user to enter a whole number representing the number of seconds.
Then the program will display how many days, hours, minutes, and leftover seconds their value represents.
*/
//import important stuff
import java.text.DecimalFormat;
import java.util.*;
class SecondsCG{
   public static void main(String[]args){
      //scanner
      Scanner keyboard = new Scanner(System.in);
      //variable
      int seconds;
      //get seconds from user
      System.out.print("Enter the number of seconds and I will convert your value to days, hours, minutes, and seconds. ");
      seconds = keyboard.nextInt();
      System.out.println();
      //math for days, hours, minutes, and seconds
      int days = seconds / (24 * 3600);
      int hours = (seconds % (24 * 3600)) / 3600;
      int minutes = (seconds % 3600) / 60;
      int sec = seconds % 60;
      //display the math
      System.out.println(seconds + " is equal to: " + days + " days " + hours + " hours " + minutes + " minutes " + sec + " seconds.");
   }
}