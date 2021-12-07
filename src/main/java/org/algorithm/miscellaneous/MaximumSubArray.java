package org.algorithm.miscellaneous;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class MaximumSubArray<T> {
    /**
     * Solve the maximum sub array problem using the divide and conquer approach.
     * We divide the subarray into two subarrays any contiguous subarray must lie in exactly one of the following
     *
     * 1) entirely in the subarray
     * 2) entirely in the subarray
     * 3) crossing the midpoint,
     *
     * We can ﬁnd maximum sub arrays of 1st & 2nd case recursively, because these two subproblems are smaller instances of the problem of ﬁnding a maximum subarray.
     * 3rd problem is not a smaller instance of our original problem, because it has the added restriction that the subarray it chooses must cross the midpoint.
     * So we find maximum subarray in time linear in the size of the subarray that crosses the midpoint.
     * Then take a subarray with the largest sum of the three.
     *
     * @param array array of objects where to find the maximum
     * @param low first index
     * @param high last index
     * @param comparator to compare the two objects
     * @param adder to add two objects
     * @param diff to subtract two objects
     * @return
     */
    public Pair solveByDivideAndConquer(List<T> array, int low, int high, BiPredicate<T, T> comparator, BiFunction<T, T, T> adder, BiFunction<T, T, T> diff) {

        if (low == high) {
            return new Pair(low, high, array.get(low));
        }

        int mid_point = (low + high) >> 1;

        // Divide & Conquer
        Pair left_sub_array = solveByDivideAndConquer(array, low, mid_point, comparator, adder, diff);
        Pair right_aub_array = solveByDivideAndConquer(array, mid_point + 1, high, comparator, adder, diff);

        // Combine
        T max_right_subarray = array.get(mid_point);
        int max_right_subarray_at = mid_point;
        T sum = array.get(mid_point);
        for (int i = mid_point + 1; i <= high; ++i) {
            sum = adder.apply(sum, array.get(i));
            boolean is_greater = comparator.test(max_right_subarray, sum);
            max_right_subarray_at = is_greater ? i : max_right_subarray_at;
            max_right_subarray = is_greater ? sum : max_right_subarray;
        }

        T max_left_subarray = array.get(mid_point);
        int max_left_subarray_at = mid_point;
        sum = array.get(mid_point);

        for (int i = mid_point - 1; i >= low; --i) {
            sum = adder.apply(sum, array.get(i));
            boolean is_greater = comparator.test(max_left_subarray, sum);
            max_left_subarray_at = is_greater ? i : max_left_subarray_at;
            max_left_subarray = is_greater ? sum : max_left_subarray;
        }

        max_left_subarray = diff.apply(max_left_subarray, array.get(mid_point));
        T cross_sub_array = adder.apply(max_left_subarray, max_right_subarray);

        if (!comparator.test(cross_sub_array, left_sub_array.sum) && !comparator.test(cross_sub_array, left_sub_array.sum))
            return new Pair(max_left_subarray_at, max_right_subarray_at, cross_sub_array);

        if (!comparator.test(left_sub_array.sum, right_aub_array.sum))
            return left_sub_array;

        return right_aub_array;
    }

    public class Pair {
        public int low;
        public int high;
        public T sum;

        Pair(int low, int high, T sum) {
            this.low = low;
            this.high = high;
            this.sum = sum;
        }

    }
}
