/* Cooper Gadd
CSC 101
This program will allow a user to play Rock, Paper, Scissors against the computer.
*/
//import everything needed
import java.util.*;
class GameCG{
   public static void main(String[]args){
      //scanner
      Scanner keyboard = new Scanner(System.in);
      //random
      Random random = new Random();
      //inform user on the game they are playing
      System.out.println("Let's play Rock, Paper, Scissors!");
      //initialize variables
      int comp;
      int user;
      int win=0;
      int compwin=0;
      int tie=0;
      boolean check = true;
      //while loop for game
      while(check==true){
         //tell user what their input can include
         System.out.println("Make your selection: (1 for Rock, 2 for Paper, 3 for Scissors, 0 to End)");
         //assign the user input to a variable
         user = keyboard.nextInt();
         //assign the random numbers (1 through 3) generated to a variable
         comp = random.nextInt(3)+1;
         //if user enters 0 end loop and display total user wins, computer wins, and ties
         if(user==0){
            check=false;
            System.out.println("You won "+win+" time(s).");
            System.out.println("The computer won "+compwin+" time(s).");
            System.out.println("You tied with the computer "+tie+" time(s).");
            System.out.println("Thanks for playing! Goodbye!");
         }
         //else if to make sure user enters 1 through 3
         else if(user<0 || user>3){
            System.out.println("Please enter a number 0 through 3.");
         }
         //9 else else if statements to address all the possiblites that might arise, followed by print statements of what the computer and user picked, and who won.
         //There is also a counter that adds up each user and computer win, and ties.
         else if(user==1 && comp==3){
            win+=1;
            System.out.println("You chose rock.");
            System.out.println("The computer chose scissors.");
            System.out.println("You win!");
         }
         
         else if(user==3 && comp==2){
            win+=1;
            System.out.println("You chose scissors.");
            System.out.println("The computer chose paper.");
            System.out.println("You win!");
         }
         
         else if(user==2 && comp==1){
            win+=1;
            System.out.println("You choose paper.");
            System.out.println("The computer choose rock.");
            System.out.println("You win!");
         }
         
         else if(user==3 && comp==1){
            compwin+=1;
            System.out.println("You choose scissors.");
            System.out.println("The computer choose rock.");
            System.out.println("You lose!");
         }
         
         else if(user==2 && comp==3){
            compwin+=1;
            System.out.println("You chose paper.");
            System.out.println("The computer chose scissors.");
            System.out.println("You lose!");
         }
         
         else if(user==1 && comp==2){
            compwin+=1;
            System.out.println("You chose rock.");
            System.out.println("The computer chose paper.");
            System.out.println("You lose!");
         }
         
         else if(user==1 && comp==1 ){
            tie+=1;
            System.out.println("You chose rock.");
            System.out.println("The computer chose rock.");
            System.out.println("It's a tie!");
         }
         
         else if(user==2 && comp==2 ){
            tie+=1;
            System.out.println("You chose paper.");
            System.out.println("The computer chose paper.");
            System.out.println("It's a tie!");
         }
         
         else if(user==3 && comp==3 ){
            tie+=1;
            System.out.println("You chose scissors.");
            System.out.println("The computer chose scissors.");
            System.out.println("It's a tie!");
         }

      }
   }
}