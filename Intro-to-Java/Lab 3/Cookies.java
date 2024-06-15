import java.text.DecimalFormat;
import java.util.*;
class Cookies{
   public static void main(String[]args){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("This is a cookie calculator. ");
        DecimalFormat two = new DecimalFormat("0.00");
        double cookies = 48;
        double sugar = 1.75;
        double butter = 1;
        double flour = 2.5;
        int usrCookies;
        System.out.print("Enter the amount of cookies you'd like to make: ");
        usrCookies = keyboard.nextInt();
        System.out.println();
        double totalSugar = (sugar * usrCookies) / cookies;
        double totalButter = (butter * usrCookies) / cookies;
        double totalFlour = (flour * usrCookies) / cookies;
        System.out.println("To make " + usrCookies + " cookies, you will need:");
        System.out.println(two.format(totalSugar) + " cups of sugar.");
        System.out.println(two.format(totalButter) + " cups of butter.");
        System.out.println(two.format(totalFlour) + " cups of flour.");
        
        Random random = new Random();
        int number = random.nextInt(2000000001);
        //System.out.println(number);
        double randomTotalSugar = (sugar * number) / cookies;
        double randomTotalButter = (butter * number) / cookies;
        double randomTotalFlour = (flour * number) / cookies;
        System.out.println("Before you go, did you know that if you wanted to make " + number + " cookies, you would need:");
        System.out.println(two.format(randomTotalSugar) + " cups of sugar.");
        System.out.println(two.format(randomTotalButter) + " cups of butter.");
        System.out.println(two.format(randomTotalFlour) + " cups of flour.");

   }
}