package org.algorithm.miscellaneous;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class MaximumSubArrayTest {

    MaximumSubArray<Integer> solver;
    List<Integer> array;
    BiPredicate<Integer, Integer> comparator = (Integer a, Integer b) -> a < b;
    BiFunction<Integer, Integer, Integer> adder = (Integer a, Integer b) -> a + b;
    BiFunction<Integer, Integer, Integer> diff = (Integer a, Integer b) -> a - b;

    @Before
    public void setup() {
        solver = new MaximumSubArray<Integer>();
        array = new ArrayList<>(Arrays.asList(13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7));
    }

    @Test
    public void TestDivideAndConquerSolution() {
        MaximumSubArray.Pair temp = solver.solveByDivideAndConquer(array, 0, array.size() - 1, comparator, adder, diff);
        Assert.assertEquals(temp.sum, 43);
        Assert.assertEquals(temp.low, 7);
        Assert.assertEquals(temp.high, 10);

    }
}
