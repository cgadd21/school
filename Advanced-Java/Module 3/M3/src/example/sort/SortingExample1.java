package example.sort;

import java.util.ArrayList;
import java.util.Collections;

public class SortingExample1 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Bob");
        names.add("Ann");
        names.add("Deb");
        names.add("Cam");
        System.out.println(names);

        Collections.sort(names);

        System.out.println(names);

    }
}
