import java.io.*;

public class ObjectStreams {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("cats.txt");
        FileOutputStream fileOut = new FileOutputStream(file);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

        Cat cat1 = new Cat("Bob", 37.5, 2001);
        Cat cat2 = new Cat("Gert", 22.2, 2007);

        objectOut.writeUTF("My cats");
        objectOut.writeObject(cat1);
        objectOut.writeObject(cat2);

        FileInputStream fileIn = new FileInputStream(file);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);

        //readObject only returns generic Object object
        //Must cast back to the desired type - Cat
        String title = objectIn.readUTF();
        Cat aCat = (Cat)objectIn.readObject();
        Cat anotherCat = (Cat)objectIn.readObject();

        System.out.println(title);
        System.out.println(aCat);
        System.out.println(anotherCat);

    }
}
