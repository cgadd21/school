import java.util.HashSet;
import java.util.Set;

public class Example3 {
    public static void main(String[] args) {
        Set<String> states = new HashSet<>();
        states.add("New York");
        states.add("Maine");
        states.add("Florida");
        states.add("Texas");
        states.add("Pennsylvania");
        states.add("New York");

        System.out.println("HashSet");
        for(String s: states){
            System.out.println(s);
        }
        System.out.println();
    }
}
