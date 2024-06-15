import java.util.TreeSet;

public class Example5 {
    public static void main(String[] args) {
        TreeSet<String> countries = new TreeSet<>();
        countries.add("Spain");
        countries.add("Spain");
        countries.add("Kenya");
        countries.add("Japan");
        countries.add("Mexico");
        countries.add("Canada");
        System.out.println("TreeSet - Alphabetical order, no duplicates");
        //Since it is holding strings, they will be ordered alphabetically
        //Duplicates are removed
        for(String co: countries){
            System.out.println(co);
        }
    }
}
