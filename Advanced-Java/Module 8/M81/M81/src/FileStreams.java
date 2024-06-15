import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreams {
    public static void main(String[] args) throws IOException {
        //Offers very low level write and read binary functionality
        File file = new File("student.txt");
        FileOutputStream output = new FileOutputStream(file);
        output.write(100);
        FileInputStream input = new FileInputStream(file);
        System.out.println(input.read());
    }
}
