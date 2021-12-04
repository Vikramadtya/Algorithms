package org.algorithm.search;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class LinearSearch<V> implements Search<V> {

    @Override
    public Boolean isThere(List<V> array, V value, Comparator<V> comparator) {
        for (V x : array)
            if (comparator.compare(value,x) == 0)
                return true;
        return false;
    }

    @Override
    public int search(List<V> array, V value, Comparator<V> comparator) {
        for (int i = 0; i < array.size(); ++i)
            if (comparator.compare(array.get(i),value) == 0)
                return i;
        return -1;
    }
}
