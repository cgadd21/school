/* Cooper Gadd
CSC 101
This program will ask the user for a String and a character and display some information back to the user.
*/
//import everything needed
import java.text.DecimalFormat;
import java.util.*;
class LetterFinderCG{
   public static void main(String[]args){
      //scanner
      Scanner keyboard = new Scanner(System.in);
      //tell user what program is about
      System.out.println("This program will give you some information on the string you enter.");
      //variables
      String sentence;
      String character;
      //get sentence or phrase
      System.out.print("Please enter a sentence or phrase: ");
      sentence = keyboard.nextLine();
      System.out.println();
      //get character
      System.out.print("Please enter a single character: ");
      character = keyboard.next();
      System.out.println();
      //index and display it
      int characterLocation = sentence.indexOf(character);
      System.out.println("The index of character is: " + characterLocation);
      //get before the character substring and display it
      String before = sentence.substring(0,characterLocation);
      System.out.println("The substring before " + character + " is: " + before);
      //get length of before substring and display it
      int beforeLength = before.length();
      System.out.println("The length of the before substring is: " + beforeLength);
      //get after the character substring and display it
      String after = sentence.substring(characterLocation +1);
      System.out.println("The substring after " + character + " is: " + after);
      //get length of after substing and display it
      int afterLength = after.length();
      System.out.println("The length of the after substring is: " + afterLength);
   }
}