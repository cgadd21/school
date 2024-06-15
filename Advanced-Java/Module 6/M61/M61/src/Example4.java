import java.util.LinkedHashSet;
import java.util.Set;

public class Example4 {
    public static void main(String[] args) {
        Set<String> states = new LinkedHashSet<>();
        states.add("New York");
        states.add("Maine");
        states.add("Florida");
        states.add("Texas");
        states.add("Pennsylvania");
        states.add("New York");

        System.out.println("LinkedHashSet");
        for(String s: states){
            System.out.println(s);
        }
        System.out.println();
    }
}
