package org.algorithm.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MergeInsertionSort<V> extends SortUtility<V> implements Sort<V> {

    final int MIN_COUNT = 10;
    InsertionSort<V> sorter;

    MergeInsertionSort() {
        sorter = new InsertionSort<V>();
    }


    /**
     * Divide the problem based on divide and conquer paradigm to smaller pieces
     *
     * @param array
     * @param comparator
     * @return
     */
    private List<V> divide(List<V> array, Comparator<V> comparator) {
        if (array.size() <= MIN_COUNT) {
            return sorter.sort(array, 1, comparator);
        }

        List<V> left = array.subList(0, array.size() >> 1);
        List<V> right = array.subList(array.size() >> 1, array.size());
        left = divide(left, comparator);
        right = divide(right, comparator);
        array = merge(left, right, comparator);
        return array;
    }

    @Override
    public List<V> sort(List<V> array, int order, Comparator<V> comparator) {
        return divide(array, comparator);
    }
}
