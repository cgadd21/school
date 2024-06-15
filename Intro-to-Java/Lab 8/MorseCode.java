import java.util.*;
class MorseCode{
   public static void main(String[]args){
   Scanner scan = new Scanner(System.in);
      System.out.println("Enter a phrase or sentence and I will give you the morse code conversion.");
      String input = scan.nextLine();
      StringBuilder text = new StringBuilder("");
      for (int i = 0; i < input.length(); i++){
         char let = input.charAt(i);
         String code = getMorse(let);
         text.append(code + " ");
         
      }
      System.out.print(text);
   }
   public static String getMorse(char letter){
      String convert="";
      String converted="";
      if (Character.isLowerCase(letter)){
            letter = Character.toUpperCase(letter);
      }
      else if (Character.isUpperCase(letter)){
         letter = Character.toUpperCase(letter);
      }
      if(letter=='A'){
         converted = ".-";
      }
      else if (letter=='B'){
         converted="-...";
      }
      else if (letter=='C'){
         converted="-.-.";
      }
      else if (letter=='D'){
         converted=".";
      }
      else if (letter=='E'){
         converted=".";
      }
      else if (letter=='F'){
         converted="..-.";
      }
      else if (letter=='G'){
         converted="--.";
      }
      else if (letter=='H'){
         converted="....";
      }
      else if (letter=='I'){
         converted="..";
      }
      else if (letter=='J'){
         converted=".---";
      }
      else if (letter=='K'){
         converted="-.-";
      }
      else if (letter=='L'){
         converted=".-..";
      }
      else if (letter=='M'){
         converted="--";
      }
      else if (letter=='N'){
         converted="-.";
      }
      else if (letter=='O'){
         converted="---";
      }
      else if (letter=='P'){
         converted=".--.";
      }
      else if (letter=='Q'){
         converted="--.-";
      }
      else if (letter=='R'){
         converted=".-.";
      }
      else if (letter=='S'){
         converted="...";
      }
      else if (letter=='T'){
         converted="-";
      }
      else if (letter=='U'){
         converted="..-";
      }
      else if (letter=='V'){
         converted="...-";
      }
      else if (letter=='W'){
         converted=".--";
      }
      else if (letter=='X'){
         converted="-..-";
      }
      else if (letter=='Y'){
         converted="--.-";
      }
      else if (letter=='Z'){
         converted="--..";
      }
      else if (letter=='.'){
         converted=".-.-.-";
      }
      else if (letter==','){
         converted="--..--";
      }
      else if (letter=='?'){
         converted="..--..";
      }
      else if (letter=='/'){
         converted="-..-.";
      }
      else if (letter=='@'){
         converted=".--.-.";
      }
      else if (letter=='1'){
         converted=".----";
      }
      else if (letter=='2'){
         converted="..---";
      }
      else if (letter=='3'){
         converted="...--";
      }
      else if (letter=='4'){
         converted="....-";
      }
      else if (letter=='5'){
         converted=".....";
      }
      else if (letter=='6'){
         converted="-....";
      }
      else if (letter=='7'){
         converted="--...";
      }
      else if (letter=='8'){
         converted="---..";
      }
      else if (letter=='9'){
         converted="----.";
      }
      else if (letter=='0'){
         converted="-----";
      }
      else if (letter==' '){
         converted="  ";
      }
   return converted;
   }
}