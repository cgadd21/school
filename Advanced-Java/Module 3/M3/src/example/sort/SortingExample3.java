package example.sort;

import java.util.ArrayList;
import java.util.Collections;

public class SortingExample3 {
    public static void main(String[] args) {
        ArrayList<Cat> myCats = new ArrayList<>();
        myCats.add(new Cat("Rooney", "Domestic Short Hair", 2016, true));
        myCats.add(new Cat("Seamus", "Domestic Long Hair", 2020, true));
        myCats.add(new Cat("Batman", "Domestic Short Hair", 2006, true));
        myCats.add(new Cat("Kenneth", "Domestic Short Hair", 2012, true));
        myCats.add(new Cat("Fez", "Domestic Short Hair", 2014, true));
        myCats.add(new Cat("Dennis", "Domestic Long Hair", 2016, true));
        myCats.add(new Cat("Maryann", "Domestic Long Hair", 2020, true));
        myCats.add(new Cat("Martin", "Domestic Short Hair", 2006, true));
        myCats.add(new Cat("Arnold", "Domestic Short Hair", 2012, true));
        myCats.add(new Cat("Basketball", "Domestic Short Hair", 2014, true));

        Collections.sort(myCats);

        for(Cat cat : myCats){
            System.out.println(cat);
        }
    }
}
