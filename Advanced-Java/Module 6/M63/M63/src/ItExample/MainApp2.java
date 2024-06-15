package ItExample;

import java.util.ArrayList;
import java.util.ListIterator;

public class MainApp2 {
    public static void main(String[] args) {
        ArrayList<String> cats = new ArrayList<>();
        cats.add("Batman");
        cats.add("Kenneth");
        cats.add("Fez");
        cats.add("Rooney");

        ListIterator<String> forward = cats.listIterator();
        while(forward.hasNext()){
            System.out.println(forward.next());
        }

        ListIterator<String> back = cats.listIterator(cats.size());
        while(back.hasPrevious()){
            System.out.println(back.previous());
        }
    }
}
