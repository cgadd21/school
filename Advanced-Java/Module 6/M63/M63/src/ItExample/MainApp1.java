package ItExample;

import java.util.ArrayList;
import java.util.Iterator;

public class MainApp1 {
    public static void main(String[] args) {
        ArrayList<String> cats = new ArrayList<>();
        cats.add("Batman");
        cats.add("Kenneth");
        cats.add("Fez");
        cats.add("Rooney");

        Iterator<String> it = cats.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }

        for(String name: cats){
            System.out.println(name);
        }
    }
}
