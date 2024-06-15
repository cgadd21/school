import java.text.DecimalFormat;
import java.util.*;
class Award{
   public static void main(String[]args){
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Please enter your score to see what award you received: ");
      int score = keyboard.nextInt();
      if (score>=0 && score<=9) {
         System.out.println("No Medal");
      } else if (score>=10 && score<=19) {
         System.out.println("Honorable Mention");
      } else if (score>=20 && score<=29) {
         System.out.println("Bronze Medal");
      } else if (score>=30 && score<=39) {
         System.out.println("Silver Medal");
      } else if (score>=40 && score<=50) {
         System.out.println("Gold Medal");
      } else {
         System.out.println("Invalid entry");
      }
   }
}