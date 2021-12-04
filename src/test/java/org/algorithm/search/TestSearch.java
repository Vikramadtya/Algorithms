package org.algorithm.search;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public abstract class TestSearch {

    Search<Integer> searcher = null;
    Comparator<Integer> comparator = null;

    @Ignore
    @Test
    public void TestIsThere() {
        List<Integer> array = new ArrayList<Integer>(Arrays.asList(-1, -2, 0, 2, 3, 6, 8, 9, 10, 14, 19, 51, 62));
        Assert.assertTrue(searcher.isThere(array, 10, comparator));
        Assert.assertFalse(searcher.isThere(array, 13, comparator));
        Assert.assertFalse(searcher.isThere(array, 1, comparator));
        Assert.assertTrue(searcher.isThere(array, -2, comparator));
    }

    @Ignore
    @Test
    public void TestSearch() {
        List<Integer> array = new ArrayList<Integer>(Arrays.asList(-1, -2, 0, 2, 3, 6, 8, 9, 10, 14, 19, 51, 62));
        Assert.assertEquals(searcher.search(array, 10, comparator), 8);
        Assert.assertEquals(searcher.search(array, 13, comparator), -1);
        Assert.assertEquals(searcher.search(array, 1, comparator), -1);
        Assert.assertEquals(searcher.search(array, -2, comparator), 1);
    }
}
