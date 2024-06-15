import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TheClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8000);

        //The code that sets up the stream to "write" to the server
        OutputStream out = socket.getOutputStream();
        DataOutputStream output = new DataOutputStream(out);

        //The code that sets up the stream to "read" from the server
        InputStream in = socket.getInputStream();
        DataInputStream input = new DataInputStream(in);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter radius to find area of circle: ");
        double radius = scanner.nextDouble();

        //Write this value TO the server
        output.writeDouble(radius);
        //Get double back from server and save to variable
        double answer = input.readDouble();
        System.out.println("Area is " + answer);
    }
}
