package org.algorithm.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public abstract class SortUtility<V> {
    /**
     * Swap the elements at index left and right in the array
     * @param array
     * @param left
     * @param right
     */
    public void swap(List<V> array, int left, int right) {
        V temp = array.get(left);
        array.set(left, array.get(right));
        array.set(right, temp);
    }

    /**
     * Merge the two sorted sub arrays
     *
     * @param left
     * @param right
     * @param comparator
     * @return
     */
    public List<V> merge(List<V> left, List<V> right, Comparator<V> comparator) {
        List<V> merged = new ArrayList<V>();
        int i = 0, j = 0;
        for (; i < left.size() && j < right.size(); ) {
            merged.add(comparator.compare(left.get(i), right.get(j)) < 0 ? left.get(i++) : right.get(j++));
        }

        for (; i < left.size(); ++i)
            merged.add(left.get(i));

        for (; j < right.size(); ++j)
            merged.add(right.get(j));

        return merged;
    }
}
