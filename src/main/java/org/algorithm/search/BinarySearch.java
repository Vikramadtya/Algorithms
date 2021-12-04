package org.algorithm.search;

import java.util.Comparator;
import java.util.List;

public class BinarySearch<V> implements Search<V> {

    @Override
    public Boolean isThere(List<V> array, V value, Comparator<V> comparator) {
        return (search(array, value, comparator) != -1);
    }

    private int binarySearch(List<V> array, V value, Comparator<V> comparator, int left, int right) {

        int mid_point = (left + right) >> 1, comparison = comparator.compare(value, array.get(mid_point));

        if (left == right & comparison != 0) {
            return -1;
        }


        if (comparison == 0) {
            return mid_point;
        }
        if (comparison < 0) {
            return binarySearch(array, value, comparator, left, mid_point - 1);
        } else {
            return binarySearch(array, value, comparator, mid_point + 1, right);
        }
    }

    @Override
    public int search(List<V> array, V value, Comparator<V> comparator) {
        return binarySearch(array, value, comparator, 0, array.size() - 1);
    }
}
