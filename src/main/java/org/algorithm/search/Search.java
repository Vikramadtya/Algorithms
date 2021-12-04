package org.algorithm.search;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public interface Search<V> {
    /**
     * Search the array for the value & tell if its there
     *
     * @param array array of element
     * @param value the value to search
     * @return true or false
     */
    Boolean isThere(List<V> array, V value, Comparator<V> comparator);

    /**
     * Search the array for the value
     *
     * @param array array of element
     * @param value the value to search
     * @return index of the value
     */
    int search(List<V> array, V value, Comparator<V> comparator);
}