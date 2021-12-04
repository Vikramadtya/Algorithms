package org.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public class SelectionSort<T> implements Sort<T> {

    @Override
    public List<T> sort(List<T> array, int order, BiPredicate<T, T> comparator) {
        for (int i = 0; i < array.size(); ++i) {
            int smallest_index = i;
            if (smallest_index < array.size()) {
                for (int j = smallest_index; j < array.size(); ++j) {
                    if (comparator.test(array.get(j), array.get(smallest_index))) {
                        smallest_index = j;
                    }
                }

                T temp = array.get(i);
                array.set(i, array.get(smallest_index));
                array.set(smallest_index, temp);
            }
        }
        return array;
    }

}
