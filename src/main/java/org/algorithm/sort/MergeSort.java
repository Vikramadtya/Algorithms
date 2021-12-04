package org.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;


public class MergeSort <V> implements Sort<V> {

    private List<V> merge(List<V> left, List<V> right, BiPredicate<V, V> comparator) {
        List<V> merged = new ArrayList<V>();
        int i = 0, j = 0;
        for (; i < left.size() && j < right.size(); ) {
            merged.add(comparator.test(left.get(i), right.get(j)) ? left.get(i++) : right.get(j++));
        }

        for (; i < left.size(); ++i)
            merged.add(left.get(i));

        for (; j < right.size(); ++j)
            merged.add(right.get(j));

        return merged;
    }

    @Override
    public List<V> sort(List<V> array, int order, BiPredicate<V, V> comparator) {

        if (array.size() <= 1) {
            return array;
        }

        List<V> left = array.subList(0, array.size() >> 1);
        List<V> right = array.subList(array.size() >> 1, array.size());
        left = sort(left, order, comparator);
        right = sort(right, order, comparator);
        array = merge(left, right, comparator);
        return array;
    }


}