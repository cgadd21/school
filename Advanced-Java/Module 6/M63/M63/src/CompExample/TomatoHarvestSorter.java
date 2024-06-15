package CompExample;

import java.util.Comparator;

public class TomatoHarvestSorter implements Comparator<Tomato> {
    @Override
    public int compare(Tomato o1, Tomato o2) {
        if(o1.getDaysToHarvest() == o2.getDaysToHarvest()){
            return o1.getVariety().compareTo(o2.getVariety());
        } else if (o1.getDaysToHarvest() > o2.getDaysToHarvest()){
            return 1;
        } else {
            return -1;
        }
    }
}
