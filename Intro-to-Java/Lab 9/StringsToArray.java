import java.util.*;
class StringsToArray{
   public static void main(String[]args){
      Scanner scan = new Scanner(System.in);
      Scanner keyboard = new Scanner(System.in);
      String[] user;
      System.out.println("This program will show you the length of your strings.");
      System.out.println("How many strings would you like to enter?");
      int num = scan.nextInt();
      user = new String[num];
      for(int i=0; i<num; i++){
         System.out.println("Enter string "+(i+1)+".");
         user[i] = keyboard.nextLine();
      }
      for(int i=0; i<num; i++){
         System.out.println(user[i]+" = "+user[i].length());
      }
      
      System.out.println("Goodbye.");   
   }
}