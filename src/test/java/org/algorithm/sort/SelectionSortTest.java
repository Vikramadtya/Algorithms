package org.algorithm.sort;

import org.junit.Before;

public class SelectionSortTest extends SortTest{
    @Before
    public void setup() {
        sorter = new SelectionSort<Integer>();

    }
}
