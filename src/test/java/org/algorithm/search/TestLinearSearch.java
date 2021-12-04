package org.algorithm.search;

import org.junit.Before;

public class TestLinearSearch extends TestSearch {
    @Before
    public void setup() {
        searcher = new LinearSearch<Integer>();
        comparator = (Integer a, Integer b) -> {
            if (a < b) return -1;
            if (a > b) return 1;
            return 0;
        };
    }
}
