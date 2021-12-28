package org.algorithm.sort;

import java.util.List;
import java.util.function.BiPredicate;

public class QuickSort<V> implements Sort<V> {
    private int getPivotIndex(int left, int right) {
        return right;
    }

    private void swap(List<V> array, int left, int right) {
        V temp = array.get(left);
        array.set(left, array.get(right));
        array.set(right, temp);
    }

    private int partition(List<V> array, int left, int right, BiPredicate<V, V> comparator) {
        int pivotIndex = getPivotIndex(left, right);
        V pivot = array.get(pivotIndex);

        if (pivotIndex != array.size() - 1)
            swap(array, pivotIndex, right);

        int i = left-1;
        for (int j = left; j <= right - 1; ++j) {
            if (comparator.test(array.get(j), pivot)) {
                swap(array, j, ++i);
            }
        }
        swap(array, pivotIndex, ++i);
        return i;
    }

    public void quickSort(List<V> array, int left, int right, BiPredicate<V, V> comparator) {
        if (left < 0 || right > array.size() || left >= right)
            return;

        int pivot = partition(array, left, right, comparator);
        quickSort(array, left, pivot - 1, comparator);
        quickSort(array, pivot + 1, right, comparator);
    }

    @Override
    public List<V> sort(List<V> array, int order, BiPredicate<V, V> comparator) {
        quickSort(array,0,array.size()-1,comparator);
        return array;
    }
}