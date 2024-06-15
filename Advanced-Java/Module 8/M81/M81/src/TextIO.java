import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextIO {
    public static void main(String[] args) throws IOException {
        PrintWriter writer = new PrintWriter("file.txt");
        writer.println("You can read this!");
        writer.println("I can read this!");
        writer.println("Yay!");
        writer.close();
        //Open file.txt in src to see the lines above inside
        Scanner scanner = new Scanner(new File("file.txt"));
        System.out.println(scanner.nextLine());
        System.out.println(scanner.nextLine());
        System.out.println(scanner.nextLine());
    }
}
