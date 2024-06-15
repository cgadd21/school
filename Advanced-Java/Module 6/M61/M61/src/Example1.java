import java.util.ArrayList;
import java.util.List;

public class Example1 {
    public static void main(String[] args) {
        //And Example demonstrating ArrayList methods
        List<String> catNames = new ArrayList<>();
        catNames.add("Batman");
        catNames.add("Kenny");
        catNames.add("Fez");
        catNames.add("Rooney");
        catNames.add("Seamus");
        catNames.add("Fake Cat");
        catNames.add("New Baby Kitten");

        //for each loop to iterate
        System.out.println("My Dream Cat Children");
        for(String name : catNames){
            System.out.println(name);
        }
        System.out.println("Number of dream cats: " + catNames.size());

        //Can remove by index or by object
        catNames.remove(5);
        catNames.remove("New Baby Kitten");

        //for each loop to iterate
        System.out.println();
        System.out.println("My Actual Cat Children");
        for(String name : catNames){
            System.out.println(name);
        }
        System.out.println("Number of actual cats: " + catNames.size());
    }
}
