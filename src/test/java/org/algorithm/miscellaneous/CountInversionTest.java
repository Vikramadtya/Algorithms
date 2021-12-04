package org.algorithm.miscellaneous;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CountInversionTest {
    CountInversion inverter;

    @Before
    public void setup() {
        inverter = new CountInversion();
    }

    @Test
    public void testSplitInversionWithSortedInput() {
        List<Integer> left = new ArrayList<Integer>(Arrays.asList(1, 3, 4, 5));
        List<Integer> right = new ArrayList<Integer>(Arrays.asList(8, 9, 10, 11, 12));

        HashMap<String,Object> map = inverter.splitInversion(left, right, (a, b) -> {
            if (a < b)
                return true;
            return false;
        });
        long count = (Integer) map.get("count");
        Assert.assertEquals(0,count);
    }

    @Test
    public void testSplitInversionWithUnsortedInput() {
        List<Integer> left = new ArrayList<Integer>(Arrays.asList(8, 9, 10, 11, 12));
        List<Integer> right = new ArrayList<Integer>(Arrays.asList(1, 3, 4, 5));

        HashMap<String,Object> map = inverter.splitInversion(left, right, (a, b) -> {
            if (a < b)
                return true;
            return false;
        });
        long count = (Integer) map.get("count");
        Assert.assertEquals(20,count);
    }

    @Test
    public void testGetInversion() {
        List<Integer> array = new ArrayList<Integer>(Arrays.asList(1,8,2,9,3,10,5,11,0,12,4));

        HashMap<String,Object> map = inverter.getInversions(array, (a, b) -> {
            if (a < b)
                return true;
            return false;
        });
        long count = (Integer) map.get("count");
        Assert.assertEquals(20,count);
    }
}


