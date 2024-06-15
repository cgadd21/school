import java.util.Random;
import java.util.Scanner;

public class RandomNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random num = new Random();
        int sum=0;
        System.out.println("How many random values do you require?");
        int input = scanner.nextInt();
        int[] intArray = new int[input];
        for (int i=0; i< intArray.length; i++){
            intArray[i]= num.nextInt(1001);
        }
        for (int j : intArray) {
            sum+=j;
            System.out.println(j);
        }
        System.out.println("Average: " + sum/ intArray.length);
    }
}
