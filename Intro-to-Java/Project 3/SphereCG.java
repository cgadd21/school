/* Cooper Gadd
CSC 101
This program will take the the radius if a sphere and calculate the circumference, surface area, and volume.
*/
//import everything needed
import java.text.DecimalFormat;
import java.util.*;
class SphereCG{
   public static void main(String[]args){
      //scanner
      Scanner keyboard = new Scanner(System.in);
      //three decimal format
      DecimalFormat three = new DecimalFormat("0.000");
      //variable for radius
      double rad = 0;
      //tell user the what's the program is about
      System.out.println("This program will take the radius if a sphere and calculate the circumference, surface area, and volume.");
      //set boolean
      boolean check=true;
      //while loop
      while(check==true){
         //try getting number for radius
         try{
            System.out.println("Please enter the radius of a sphere. Entering 0 or a negative value will exit the program.");
            rad = keyboard.nextDouble();
            //if radius is 0 or less make program quit
            if(rad<=0){
               System.out.println("Goodbye.");
               check=false;
            }
         //if radius is not 0 or neg
            else{
               //assign static methods to variables and pring them
               double circ = getCircumference(rad);
               double surf = getSurfaceArea(rad);
               double vol = getVolume(rad);
               System.out.println("Radius: "+three.format(rad));
               System.out.println("Circumference: "+three.format(circ));
               System.out.println("Surface Area: "+three.format(surf));
               System.out.println("Volume: "+three.format(vol));
            }
         }
         //catch if radius is not a number
         catch (Exception e){
            System.out.println("Must be number.");
            //clear the pipe
            keyboard.nextLine();
         }
      }    
   }
   //static method for getting the circumference
   public static double getCircumference(double radius){
      return 2*Math.PI*radius;
   }
   //static method for getting the surface area
   public static double getSurfaceArea(double radius){
      return 4*Math.PI*Math.pow(radius,2);
   }
   //static method for getting the volume
   public static double getVolume(double radius){
      return (4.0/3)*Math.PI*Math.pow(radius,3);
   }
}