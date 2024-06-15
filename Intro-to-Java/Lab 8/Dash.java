import java.util.*;
class Dash{
   public static void main(String[]args){
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter a phrase or sentence and I will flip it.");
      String input = scan.nextLine();
      for (int i = 0; i < input.length(); i++){
         char letter = input.charAt(i);
         if (Character.isLowerCase(letter)){
            letter = Character.toUpperCase(letter);
         }
         else if (Character.isUpperCase(letter)){
            letter = Character.toLowerCase(letter);
         }
         else if (Character.isWhitespace(letter)){
            letter = '-';
         }
         System.out.print(letter);
      }
   }
}