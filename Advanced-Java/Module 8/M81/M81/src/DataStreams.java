import java.io.*;

public class DataStreams {
    public static void main(String[] args) throws IOException {
        //Allows specific data types to be written and read
        File file = new File("text.txt");
        FileOutputStream fileOut = new FileOutputStream(file);
        DataOutputStream dataOut = new DataOutputStream(fileOut);
        //Write 3 strings to the file text.txt
        dataOut.writeUTF("This is the first line.");
        dataOut.writeUTF("This is the second line.");
        dataOut.writeUTF("This is the third line.");

        FileInputStream fileIn = new FileInputStream(file);
        DataInputStream dataIn = new DataInputStream(fileIn);

        //Read 3 strings from the file text.txt and print them.
        String line1 = dataIn.readUTF();
        String line2 = dataIn.readUTF();
        String line3 = dataIn.readUTF();

        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);


    }
}
