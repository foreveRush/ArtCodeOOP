package ua.artcode.week5.sort;

import java.util.Comparator;

/**
 * Created by Serhii Fursenko on 28.07.16.
 */
public class DuckWeightComparator implements Comparator<Duck> {
    @Override
    public int compare(Duck o1, Duck o2) {
        return o1.weight<o2.weight? -1 : o1.weight>o2.weight? 1 : 0;
    }
}
