package org.algorithm.sort;

import org.junit.Before;

public class MergeSortTest extends SortTest {
    @Before
    public void setup() {
        sorter = new MergeSort<Integer>();

        comparator = (Integer a, Integer b) -> {
            if (a <= b)
                return true;
            return false;
        };
    }
}
