package org.algorithm.sort;

import org.junit.Before;

public class InsertionSortTest extends SortTest {
    @Before
    public void setup() {
        sorter = new InsertionSort<Integer>();
    }
}
