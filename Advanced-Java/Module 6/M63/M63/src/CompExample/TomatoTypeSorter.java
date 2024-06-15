package CompExample;

import java.util.Comparator;

public class TomatoTypeSorter implements Comparator<Tomato> {
    @Override
    public int compare(Tomato o1, Tomato o2) {
        return o1.getType().compareTo(o2.getType());
    }
}
