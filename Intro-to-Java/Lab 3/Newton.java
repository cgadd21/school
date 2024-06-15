import java.text.DecimalFormat;
import java.util.*;
class Newton{
   public static void main(String[]args){
      Scanner keyboard = new Scanner(System.in);
      DecimalFormat three = new DecimalFormat("0.000E00");
      final double GRAVITATIONAL_CONSTANT = 6.674E-11;
      double mass1;
      double mass2;
      double distance;
      System.out.print("Enter the mass of object 1 in kilograms: ");
      mass1 = keyboard.nextDouble();
      System.out.println();
      System.out.print("Enter the mass of object 2 in kilograms: ");
      mass2 = keyboard.nextDouble();
      System.out.println();
      System.out.print("Enter the distance from the center of object 1 to the center of object 2 in meters: ");
      distance = keyboard.nextDouble();
      System.out.println();
      double gravForce = GRAVITATIONAL_CONSTANT * ((mass1 * mass2)/Math.pow(distance,2));
      System.out.println("The gravitational force between the two objects is " + three.format(gravForce) + " Newtons.");
   }
}