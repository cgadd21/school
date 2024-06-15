import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TheServer {
    public static void main(String[] args) throws IOException {
        //Create server socket on port 8000
        ServerSocket server = new ServerSocket(8000);
        //Creates a socket object to connect to a client
        Socket socket = server.accept();

        //The code that sets up the stream to "write" to the client
        OutputStream out = socket.getOutputStream();
        DataOutputStream sOutput = new DataOutputStream(out);

        //The code that sets up the stream to "read" from the client
        InputStream in = socket.getInputStream();
        DataInputStream sInput = new DataInputStream(in);

        //Gets double from the input stream - from client
        double clientsRadius = sInput.readDouble();
        //Do math
        double area = Math.PI * Math.pow(clientsRadius, 2);
        //send answer back to client using output stream
        sOutput.writeDouble(area);
    }
}
