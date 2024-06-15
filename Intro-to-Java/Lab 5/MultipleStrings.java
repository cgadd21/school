import java.text.DecimalFormat;
import java.util.*;
class MultipleStrings{
   public static void main(String[]args){
      Scanner keyboard = new Scanner(System.in);
      String sentence1;
      int num1;
      String sentence2;
      int num2;
      System.out.println("Please enter a sentence. ");
      sentence1 = keyboard.nextLine();
      System.out.println("Please enter a positive number. ");
      num1 = keyboard.nextInt();
      for(int i = 0; i < num1; i++){
         System.out.println(i+1 + ". " +sentence1);
      }
      Scanner scan = new Scanner(System.in);
      System.out.println("Please enter another sentence. ");
      sentence2 = scan.nextLine();
      System.out.println("Please enter another positive number. ");
      num2 = scan.nextInt();
      int counter = 1;
      while(counter <= num2){
         System.out.println(counter + ". " +sentence2);
         counter++;
      }

   }
}