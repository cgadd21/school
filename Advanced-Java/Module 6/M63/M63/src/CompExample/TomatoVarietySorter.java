package CompExample;

import java.util.Comparator;

public class TomatoVarietySorter implements Comparator<Tomato> {
    @Override
    public int compare(Tomato o1, Tomato o2) {
        return o1.getVariety().compareTo(o2.getVariety());
    }
}
