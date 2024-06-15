/* Cooper Gadd
CSC 101
This program will ask the user for sides A and B of a triangle.
Then the program will use the Pythagorean theorem to find side C.
*/
//import everything needed
import java.text.DecimalFormat;
import java.util.*;
class PythagoreanCG{
   public static void main(String[]args){
      //scanner
      Scanner keyboard = new Scanner(System.in);
      //tell the user what is happening
      System.out.println("This program will determine the length of the hypotenuse of a triangle and the perimenter.");
      //format setup
      DecimalFormat three = new DecimalFormat("0.000");
      //variable set up
      double sideA;
      double sideB;
      //get side a from user
      System.out.print("Please enter side A: ");
      sideA = keyboard.nextDouble();
      System.out.println();
      //get side b from user
      System.out.print("Please enter side B: ");
      sideB = keyboard.nextDouble();
      System.out.println();
      //math
      double sideAB = Math.pow(sideA, 2) + Math.pow(sideB, 2);
      double sideC = Math.sqrt(sideAB);
      double triangle = sideA + sideB + sideC;
      //display all sides and perimeter
      System.out.println("You entered " + three.format(sideA) + " as the length of side a and " + three.format(sideB) + " as the length of side b. The length of side c is " + three.format(sideC)+ ".");
      System.out.println("The perimeter of this triangle is " + three.format(triangle) + ".");

   }
}