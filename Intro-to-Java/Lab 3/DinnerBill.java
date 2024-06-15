import java.text.DecimalFormat;
import java.util.Scanner;
class DinnerBill{
   public static void main(String[]args){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("This is a restuarant bill calculator. ");
        DecimalFormat two = new DecimalFormat("0.00");
        double tax = 0.08875; //this is 8.875%
        double tip = .20; //this is 20%
        double bill;
        System.out.print("Please enter the total cost of your meal: ");
        bill = keyboard.nextDouble();
        System.out.println();
        double totalTax = bill * tax;
        double taxAndBill = totalTax + bill;
        double totalTip = taxAndBill * tip;
        double total = bill + totalTax + totalTip;
        System.out.println("Meal cost: $" + two.format(bill));
        System.out.println("Total tax: $" + two.format(totalTax));
        System.out.println("Total tip: $" + two.format(totalTip));
        System.out.println("Total due: $" + two.format(total));
        System.out.print("Goodbye.");
   }
}