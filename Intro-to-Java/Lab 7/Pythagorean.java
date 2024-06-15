import java.text.DecimalFormat;
import java.util.*;
class Pythagorean{
   public static void main(String[]args){
      Scanner keyboard = new Scanner(System.in);
      System.out.println("This program will determine the length of the hypotenuse of a triangle and the perimenter.");
      DecimalFormat three = new DecimalFormat("0.000");
      double sideA = 0;
      double sideB = 0;
      boolean check=true;
      while(check==true){
         try{
            System.out.println("Please enter side A (must be a positive value): ");
            sideA = keyboard.nextDouble();
            System.out.println();
            if (sideA <= 0){
               throw new Exception("Must be a positive value");
            }
            check=false;
         } catch (InputMismatchException e){
            System.out.println("Invalid entry. Must be a number.");
            keyboard.nextLine();
            }
            catch (Exception e){
            System.out.println(e.getMessage());
            keyboard.nextLine();
            }
      }
      check=true;
      while(check==true){
         try{
            System.out.println("Please enter side B (must be a positive value): ");
            sideB = keyboard.nextDouble();
            System.out.println();
            if (sideB <= 0){
               throw new Exception("Must be a positive value");
            }
            check=false;
         } catch (InputMismatchException e){
            System.out.println("Invalid entry. Must be a number.");
            keyboard.nextLine(); 
            }
            catch (Exception e){
            System.out.println(e.getMessage());
            keyboard.nextLine();
            }
      }
      double sideC = findC(sideA, sideB);
      double triangle = sideA + sideB + sideC;
      System.out.println("You entered " + three.format(sideA) + " as the length of side a and " + three.format(sideB) + " as the length of side b. The length of side c is " + three.format(sideC)+ ".");
      System.out.println("The perimeter of this triangle is " + three.format(triangle) + ".");

   }
   public static double findC(double side1, double side2){
      double side12 = Math.pow(side1, 2) + Math.pow(side2, 2);
      double side3 = Math.sqrt(side12);
      return side3;
   }
}