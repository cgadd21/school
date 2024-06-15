/* Cooper Gadd
CSC 101
This program will test if the user's password is strong.
*/
//import everything needed
import java.util.*;
class PasswordCG{
   public static void main(String[] args){
      //scanner
      Scanner scan = new Scanner(System.in);
      //boolean to test if pass is strong
      boolean pass=true;
      //inform the user on what to enter
      System.out.println("Enter your password to test its strength: ");
      //assign the user's string to input variable
      String input=scan.nextLine();
      //variable that uses passTest method and pass
      pass=passTest(input);
      //if the pass is true tell the user it is strong
      if(pass==true){
         System.out.println("Stronger than Chuck Norris.");
      }
      //if false tell the user it is weak
      else{
         System.out.println("Weaker than Taylor Swift.");
      }
   }
   //static method to recieve string and return boolean
   public static boolean passTest(String phrase){
      //variables
      int totalChar=phrase.length();//total char in string
      int totalUpChar=0;
      int totalLoChar=0;
      int totalNum=0;
      int totalSpChar=0;
      int test1=8;
      int test2=1;
      //loop to turn string into char then test to see the number of each type of char are in the string
      for(int i=0; i<phrase.length();i++){
         char letter=phrase.charAt(i);
      //upper and lowercase test      
      if(Character.isLowerCase(letter)){
         totalLoChar++;
      }
      else if(Character.isUpperCase(letter)){
         totalUpChar++;
      }
      //test for special char
      if(letter>=32 && letter<=47 || letter>=58 && letter<=64 || letter>=91 && letter<=95){
         totalSpChar++;
      }
      //test for numbers
      if(letter>=48 && letter<=57){
         totalNum++;
      }
      }
      //if string has all strong requirements then method returns true
      if(totalChar>=test1 && totalUpChar>=test2 && totalLoChar>=test2 && totalNum>=test2 && totalSpChar>=test2){
          return true;
      }
      //else string is false
      else{
         return false;
      }
   }
}