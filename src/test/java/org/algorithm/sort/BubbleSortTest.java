package org.algorithm.sort;

import org.junit.Before;
import org.junit.Ignore;

@Ignore
public class BubbleSortTest extends SortTest{
    @Before
    public void setup() {
        sorter = new BubbleSort<Integer>();
    }
}
