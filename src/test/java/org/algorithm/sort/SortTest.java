package org.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public abstract class SortTest {

    protected Sort<Integer> sorter = null;
    protected Comparator<Integer> comparator = Integer::compareTo;

    @Test
    public void TestSort() {
        List<Integer> array = new ArrayList<Integer>(Arrays.asList(9, 3, 4, 1, 5, 2, 10, 6, 7, 8));
        List<Integer> sorted = sorter.sort(array, 0, comparator);
        System.out.println(sorted.toString());
        Assert.assertTrue(sorted.equals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
    }

    @Test
    public void TestIsSorted() {
        Assert.assertTrue(sorter.isSorted(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), comparator));
        Assert.assertFalse(sorter.isSorted(Arrays.asList(1, 2, 3, 4, 13, 14, 7, 8, 9, 10), comparator));
    }
}
