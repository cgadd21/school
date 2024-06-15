import java.util.*;
import java.text.DecimalFormat;
class FiveNumbers{
   public static void main(String[]args){
      Scanner keyboard = new Scanner(System.in);
      System.out.println("This program will give the sum & average of 5 positive integers.");
      DecimalFormat none = new DecimalFormat("0");
      int number=0;
      double sum=0;
      double avg=0;
      for(int i=1; i<6; i++){
         try{
            System.out.print("Please enter number " + i +" ");
            number = keyboard.nextInt();
            if (number<0){
               throw new Exception("Value must be positive.");
            }
            sum+=number;
            avg=sum/5;
            }
            catch (InputMismatchException e){
            i-=1;
            System.out.println("Invalid entry. Must be a number.");
            keyboard.nextLine();
            }
            catch (Exception e){
            i-=1;
            System.out.println(e.getMessage());
            keyboard.nextLine();
            }

         
      }
      System.out.println("The sum is "+none.format(sum)+" the average of your 5 numbers is "+avg);
   }
}