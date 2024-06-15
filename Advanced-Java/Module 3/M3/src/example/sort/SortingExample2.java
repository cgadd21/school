package example.sort;

import java.util.ArrayList;
import java.util.Collections;

public class SortingExample2 {
    public static void main(String[] args) {
        ArrayList<Integer> number = new ArrayList<>();
        number.add(12);
        number.add(3);
        number.add(27);
        number.add(1);
        System.out.println(number);

        Collections.sort(number);

        System.out.println(number);
    }
}
