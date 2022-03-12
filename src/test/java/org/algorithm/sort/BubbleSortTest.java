package org.algorithm.sort;

import org.junit.Before;

public class BubbleSortTest extends SortTest{
    @Before
    public void setup() {
        sorter = new BubbleSort<Integer>();
    }
}
