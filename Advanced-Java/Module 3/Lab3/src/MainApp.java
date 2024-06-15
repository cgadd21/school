import java.util.ArrayList;
import java.util.Collections;

public class MainApp {
    public static void main(String[] args) {
        ArrayList<Products> products = new ArrayList<>();
        products.add(new iPad("Silver", 2020, 11, true));
        products.add(new iPad("Blue", 2010, 10, false));
        products.add(new iPad("Space Gray", 2019, 11, true));
        products.add(new Watch("Starlight", 2021, 41, "Aluminum"));
        products.add(new Watch("Silver", 2017, 38, "Aluminum"));
        products.add(new Watch("Space Gray", 2020, 44, "Aluminum"));

        System.out.println("For Each Loop");
        for(Products prod : products) {
            System.out.println(prod);
            prod.readyToReplace();
        }
        System.out.println("After Sort\n");
        Collections.sort(products);

        System.out.println("For Loop");
        for(int i=0; i < products.size(); i++){
            System.out.println(products.get(i));
            products.get(i).readyToReplace();
            System.out.println();
        }
    }

}
