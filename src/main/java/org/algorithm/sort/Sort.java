package org.algorithm.sort;

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
    public List<V> sort(List<V> array, int order, BiPredicate<V, V> comparator);

    /**
     * Check if the array is sorted
     * @param array
     * @param comparator
     * @return
     */
    default public boolean isSorted(List<V> array, BiPredicate<V, V> comparator) {
        for (int i = 0; i + 1 < array.size(); ++i) {
            if (!comparator.test(array.get(i), array.get(i + 1))) {
                return false;
            }
        }
        return true;
    }
}
