package org.algorithm.sort;

import org.junit.Before;

public class QuickSortTest extends SortTest{

    @Before
    public void setup(){
        sorter = new QuickSort<Integer>();
    }
}
