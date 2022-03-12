package org.algorithm.sort;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class QuickSort<V> extends SortUtility<V> implements Sort<V> {
    private int getPivotIndex(int left, int right) {
        return right;
    }

    private int partition(List<V> array, int left, int right, Comparator<V> comparator) {
        int pivotIndex = getPivotIndex(left, right);
        V pivot = array.get(pivotIndex);

        if (pivotIndex != array.size() - 1)
            swap(array, pivotIndex, right);

        int i = left-1;
        for (int j = left; j <= right - 1; ++j) {
            if (comparator.compare(array.get(j), pivot) < 0) {
                swap(array, j, ++i);
            }
        }
        swap(array, pivotIndex, ++i);
        return i;
    }

    public void quickSort(List<V> array, int left, int right, Comparator<V> comparator) {
        if (left < 0 || right > array.size() || left >= right)
            return;

        int pivot = partition(array, left, right, comparator);
        quickSort(array, left, pivot - 1, comparator);
        quickSort(array, pivot + 1, right, comparator);
    }

    @Override
    public List<V> sort(List<V> array, int order, Comparator<V> comparator) {
        quickSort(array,0,array.size()-1,comparator);
        return array;
    }
}