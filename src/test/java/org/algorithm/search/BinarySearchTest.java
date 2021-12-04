package org.algorithm.search;

import org.junit.Before;

public class BinarySearchTest extends TestSearch {

    @Before
    public void setup() {
        searcher = new BinarySearch<Integer>();
        comparator = (Integer a, Integer b) -> {
            if (a < b) return -1;
            if (a > b) return 1;
            return 0;
        };
    }
}
