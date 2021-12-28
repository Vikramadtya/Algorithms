package org.algorithm.sort;

import org.junit.Before;

public class QuickSortTest extends SortTest{

    @Before
    public void setup(){
        sorter = new QuickSort<Integer>();

        comparator = (Integer a, Integer b) -> {
            if (a <= b)
                return true;
            return false;
        };
    }
}
