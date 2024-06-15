import java.util.Scanner;
class AboutYou{
   public static void main(String[]args){
        Scanner keyboard = new Scanner(System.in);
        String name;
        String town;
        int age;
        double gpa;
        
        System.out.print("Please input your name: ");
        name = keyboard.nextLine();
        System.out.println();
        
        System.out.print("Please input your town: ");
        town = keyboard.nextLine();
        System.out.println();
        int number = town.length();
        
        System.out.print("Please input your age: ");
        age = keyboard.nextInt();
        System.out.println();
        
        System.out.print("Please input your gpa: ");
        gpa = keyboard.nextDouble();
        System.out.println();
        
        System.out.println("Your name is " + name + " and you live in " + town + ". You are " + age + " years old and your GPA is " + gpa + ".");
        System.out.println("Your town has " + number + " letters.");
   }
}