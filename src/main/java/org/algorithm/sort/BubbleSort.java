package org.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public class BubbleSort<V> implements Sort<V> {

    private void swap(List<V> array, int left, int right) {
        V temp = array.get(left);
        array.set(left, array.get(right));
        array.set(right, temp);
    }

    @Override
    public List<V> sort(List<V> array, int order, BiPredicate<V, V> comparator) {
        for (int i = 0; i < array.size(); ++i) {
            for (int j = array.size() - 1; j - 1 >= i; --j) {
                if (comparator.test(array.get(j), array.get(j-1))) {
                    swap(array, j, j-1);
                }
            }
        }
        return array;
    }
}
