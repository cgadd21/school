import java.text.DecimalFormat;
import java.util.*;
class Multiples{
   public static void main(String[]args){
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Please enter your first number (the divident): ");
      int num1 = keyboard.nextInt();
      System.out.print("Please enter your second number (the divisor): ");
      int num2 = keyboard.nextInt();
      int remander = num1 % num2;
      switch(remander){
         case 0: System.out.print(num1 + " is a multiple of " + num2 + ".");
            break;
         default: System.out.print(num1 + " is not a multiple of " + num2 + ".");
            break;
      }
   }
}