import java.util.Scanner;
class MathPractice{
   public static void main(String[]args){
        Scanner keyboard = new Scanner(System.in);
        double num1;
        double num2;
        //get first number
        System.out.print("Please enter your first number: ");
        num1 = keyboard.nextDouble();
        System.out.println();
        //get second number
        System.out.print("Please enter your second number: ");
        num2 = keyboard.nextDouble();
        System.out.println();
        //sum
        double sum = num1 + num2;
        System.out.println(num1 + " + " + num2 + " = " + sum);
        //product
        double product = num1 * num2;
        System.out.println(num1 + " * " + num2 + " = " + product);
        //min and max of numbers
        double biggest = Math.max(num1, num2);
        double smallest = Math.min(num1, num2);
        //biggest number base, smallest number exponent
        double power = Math.pow(biggest, smallest);
        System.out.println(biggest + " ^ " + smallest + " = " + power);
        //get absolute value, then square root the biggest number
        double absBiggest = Math.abs(biggest);
        double squareRoot = Math.sqrt(absBiggest);
        System.out.println("The square root of " + absBiggest + " is " + squareRoot);
        //round up numbers, then add them up
        double num1GoUp = Math.ceil(num1);
        double num2GoUp = Math.ceil(num2);
        double sumGoUp = num1GoUp + num2GoUp;
        System.out.println(num1GoUp + " + " + num2GoUp + " = " + sumGoUp);
        //subtract second number from first number, then subtract first number from second number, then smallest number will be displayed
        double sum2 = num1 - num2;
        double sum3 = num2 - num1;
        double smallest2 = Math.min(sum2, sum3);
        System.out.println(num1 + " - " + num2 + " = " + sum2 + " and " + num2 + " - " + num1 + " = " + sum3 + ". The smallest of these numbers is " + smallest2);
        
        

   }
}