package org.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

/**
 * Implements the merge sort, an efﬁcient algorithm for sorting elements.
 * it works on the principle of divide and conquer.
 *
 * @param <V>
 */
public class MergeSort<V> extends SortUtility<V> implements Sort<V> {

    /**
     * Divide the problem based on divide and conquer paradigm to smaller pieces
     * @param array
     * @param comparator
     * @return
     */
    private List<V> mergeSort(List<V> array, Comparator<V> comparator) {
        if (array.size() <= 1) {
            return array;
        }

        List<V> left = array.subList(0, array.size() >> 1);
        List<V> right = array.subList(array.size() >> 1, array.size());
        left = mergeSort(left, comparator);
        right = mergeSort(right, comparator);
        array = merge(left, right, comparator);
        return array;
    }

    @Override
    public List<V> sort(List<V> array, int order, Comparator<V> comparator) {
        return mergeSort(array, comparator);
    }


}