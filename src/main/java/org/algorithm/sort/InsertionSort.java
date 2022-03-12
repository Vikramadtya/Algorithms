package org.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

/**
 * Implements the insertion sort, an efﬁcient algorithm for sorting a small number of elements.
 * Insertion sort works the way people sort a hand of playing cards.
 *
 * @param <V>
 */
public class InsertionSort<V> extends SortUtility<V> implements Sort<V> {

    private List<V> insertionSort(List<V> array, Comparator<V> comparator) {
        for (int i = 1; i < array.size(); ++i) {
            V temp = array.get(i);
            for (int j = i - 1; j >= 0; --j) {
                if (comparator.compare(array.get(j), temp) < 0) {
                    array.set(j + 1, temp);
                    break;
                }
                array.set(j + 1, array.get(j));
                if (j == 0) array.set(j, temp);
            }
        }
        return array;
    }

    /**
     * The algorithm sorts the input numbers in place
     * it rearranges the numbers within the array A, with at most a constant number of them stored outside the array at any time.
     *
     * @param array      to be sorted
     * @param order      increasing or decreasing
     * @param comparator function to compare two values
     * @return
     */
    @Override
    public List<V> sort(List<V> array, int order, Comparator<V> comparator) {
        if (array.isEmpty() || array.size() == 1 || isSorted(array, comparator))
            return array;

        return insertionSort(array, comparator);
    }
}
