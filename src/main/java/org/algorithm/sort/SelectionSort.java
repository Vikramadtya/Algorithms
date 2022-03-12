package org.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class SelectionSort<V> extends SortUtility<V> implements Sort<V> {

    private List<V> selectionSort(List<V> array, Comparator<V> comparator) {
        for (int i = 0; i < array.size(); ++i) {
            int smallest_index = i;
            if (smallest_index < array.size()) {
                for (int j = smallest_index; j < array.size(); ++j) {
                    if (comparator.compare(array.get(j), array.get(smallest_index)) < 0) {
                        smallest_index = j;
                    }
                }

                V temp = array.get(i);
                array.set(i, array.get(smallest_index));
                array.set(smallest_index, temp);
            }
        }
        return array;
    }
    @Override
    public List<V> sort(List<V> array, int order, Comparator<V> comparator) {
        return selectionSort(array,comparator);
    }

}
