import java.text.DecimalFormat;
import java.util.*;
class Adventure{
   public static void main(String[]args){
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Welcome to The North Pole! ");
      System.out.print("You decide just to wing it and go exploring. ");
      System.out.print("Would you like to go left or right? (Press 1 for left, 2 for right.) ");
      int dec1 = keyboard.nextInt();
      if (dec1 == 1){
         System.out.println("You enter Santa's workshop. Would you like to steal a toy? (Press 1 for yes, 2 for no.) ");
         int leftDec1 = keyboard.nextInt();
         if (leftDec1 == 1){
            System.out.println("An elf catches you! He asks what is wrong with you. Elf security kicks you out and puts you on the naughty list! ");
         } else if (leftDec1 == 2){
            System.out.println("An elf notices you. He offers you a tour of the workshop. You enjoy the tour and go home.");
         } else{
            System.out.println("That wasn't an option. Goodbye.");
         } 
      }
      else if (dec1 == 2){
         System.out.println("You enter the reindeer's section. Would you like to steal the a reindeer? (Press 1 for yes, 2 for no.) ");
         int rightDec1 = keyboard.nextInt();
         if (rightDec1 == 1){
            System.out.println("The reindeer asks what is wrong with you. You leave because an animal just talked to you. ");
         } else if (rightDec1 == 2){
            System.out.println("Santa notices you. He offers you a ride on his sled. You enjoy the ride and he drops you off at home.");
         } else{
            System.out.println("That wasn't an option. Goodbye.");
         }
         }
      else{
         System.out.println("That wasn't an option. Goodbye.");
      }  
   } 
}      

   
