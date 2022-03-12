package org.algorithm.sort;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public interface Sort <V> {
    /**
     * Sort the provided array
     * @param array to be sorted
     * @param order increasing or decreasing
     * @param comparator function to compare two values
     * @return
     */
    public List<V> sort(List<V> array, int order, Comparator<V> comparator);

    /**
     * Check if the array is sorted
     * @param array
     * @param comparator
     * @return
     */
    default public boolean isSorted(List<V> array, Comparator<V> comparator) {
        for (int i = 0; i + 1 < array.size(); ++i) {
            if (comparator.compare(array.get(i), array.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }
}
