package org.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class BubbleSort<V> extends SortUtility<V> implements Sort<V> {
    public List<V> bubbleSort(List<V> array, Comparator<V> comparator) {
        for (int i = 0; i < array.size(); ++i) {
            for (int j = array.size() - 1; j - 1 >= i; --j) {
                if (comparator.compare(array.get(j), array.get(j - 1)) > 0) {
                    swap(array, j, j - 1);
                }
            }
        }
        return array;
    }

    /**
     * @param array      to be sorted
     * @param order      increasing or decreasing
     * @param comparator function to compare two values
     * @return
     */
    @Override
    public List<V> sort(List<V> array, int order, Comparator<V> comparator) {
        return bubbleSort(array,comparator);
    }
}
