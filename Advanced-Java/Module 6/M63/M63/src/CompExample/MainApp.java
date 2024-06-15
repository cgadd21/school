package CompExample;

import java.util.ArrayList;
import java.util.Collections;

public class MainApp {
    public static void main(String[] args) {
        ArrayList<Tomato> tomatoes = new ArrayList<>();

        tomatoes.add(new Tomato("Yellow Canary", "Cherry", "Yellow", false, 14, 55 ));
        tomatoes.add(new Tomato("Nature's Bites", "Cherry", "Red", true, 14, 70));
        tomatoes.add(new Tomato("Pony Express", "Roma", "Red", false, 14, 72));
        tomatoes.add(new Tomato("Sugar Plum", "Grape", "Red", true, 14, 67));
        tomatoes.add(new Tomato("Red Grape", "Grape", "Red", true, 14, 70));
        tomatoes.add(new Tomato("Beefsteak", "Beefsteak", "Red", true, 14, 90));
        tomatoes.add(new Tomato("Plum Regal", "Roma", "Red", false, 14, 75));
        tomatoes.add(new Tomato("Lizziebelle", "Plum", "Orange", true, 14, 60));

        /*Collections.sort(tomatoes);
        System.out.println(tomatoes);*/

        TomatoHarvestSorter sort2 = new TomatoHarvestSorter();
        Collections.sort(tomatoes, sort2);
        System.out.println(tomatoes);

        TomatoVarietySorter sort1 = new TomatoVarietySorter();
        Collections.sort(tomatoes, sort1);
        System.out.println(tomatoes);



    }
}
