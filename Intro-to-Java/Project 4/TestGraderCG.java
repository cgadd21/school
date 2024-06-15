/* Cooper Gadd
CSC 101
This program will compare the user's answer to the actual answer and tell them their score.
*/
//import everything needed
import java.util.*;
import java.text.DecimalFormat;
class TestGraderCG{
   public static void main(String[] args){
      //scanner
      Scanner scan = new Scanner(System.in);
      //decimal format for grade
      DecimalFormat none = new DecimalFormat("0");
      //char array for the user input
      char[] user = new char[20];
      //char array for the answer key
      char[] answers = new char[20];
      //variables
      int correctCounter=0;
      double grade;
      String input;
      char letter;
      String message;
      boolean check=true;
      //array of correct answers
      answers[0]='B';
      answers[1]='D';
      answers[2]='A';
      answers[3]='A';
      answers[4]='C';
      answers[5]='A';
      answers[6]='B';
      answers[7]='A';
      answers[8]='C';
      answers[9]='D';
      answers[10]='B';
      answers[11]='C';
      answers[12]='D';
      answers[13]='A';
      answers[14]='D';
      answers[15]='C';
      answers[16]='C';
      answers[17]='B';
      answers[18]='D';
      answers[19]='A';
      //tell user what to do 
      System.out.println("Please enter the answers to the 20 questions.");
      //loop to fill user array
      for(int i=0; i<answers.length; i++){
         System.out.println("Enter the answer to Question "+(i+1)+".");
         //try incase of input we do not want
         try{
               //turn user input into strig
               input=scan.next();
               //clear buffer
               scan.nextLine();
               //turn string into char
               letter=input.charAt(0);
               //turn lowercase char into uppercase
               if(Character.isLowerCase(letter)){
                  letter = Character.toUpperCase(letter);
               }
               //exception to guarentee the char is a,b,c,d
               if(letter!='A' && letter!='B' && letter!='C' && letter!='D'){
                  throw new Exception("Answers are between A and D.");
               }
               //put the char into user array
               user[i]=letter;
               //if user array is equal to the answer key array in i spot then display correct
               if(answers[i]==user[i]){
                  System.out.println("Correct.");
                  correctCounter++;
               }
               //if they not equal then display incorrect
               else{
                  System.out.println("Incorrect.");
               }
         }
         //catch wrong input
         catch(Exception e){
            System.out.println(e.getMessage());
            //repeat question
            i-=1;
         }
      }
      //math to calc grade
      grade=(correctCounter/20.0)*100.0;
      //if grade is or above 65 then assign message to pass
      if(grade>=65){
         message="You passed!";
      }
      //if below 65 then display fail
      else{
         message="You failed. :(";
      }
      //display the number correct
      System.out.println("You answered "+correctCounter+" out of 20 correctly.");
      //display grade
      System.out.println("Your grade is "+none.format(grade)+"%");
      //display pass or fail
      System.out.println(message);
      
   }
}