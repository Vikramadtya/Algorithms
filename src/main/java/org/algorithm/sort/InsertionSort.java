package org.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

/**
 * Implements the insertion sort an efﬁcient algorithm for sorting a small number of elements.
 * Insertion sort works the way people sort a hand of playing cards.
 *
 * @param <V>
 */
public class InsertionSort<V> implements Sort<V> {

    /**
     * We start with an empty left hand and the cards face down on the table.
     * We then remove one card at a time from the table and insert it into the correct position in the left hand.
     * To ﬁnd the correct position for a card, we compare it with each of the cards already in the hand, from right to left.
     * At all times, the cards held in the left hand are sorted. The algorithm sorts the input numbers in place:
     * it rearranges the numbers within the array A, with at most a constant number of them stored outside the array at any time.
     *
     * @param array      to be sorted
     * @param order      increasing or decreasing
     * @param comparator function to compare two values
     * @return
     */
    @Override
    public List<V> sort(List<V> array, int order, BiPredicate<V, V> comparator) {
        if(array.isEmpty() || array.size() == 1)
            return array;
        
        for (int i = 1; i < array.size(); ++i) {
            V temp = array.get(i);
            int itr = i - 1;
            for (; itr >= 0 && !comparator.test(array.get(itr), temp); --itr) {
                array.set(itr + 1, array.get(itr));
            }
            array.set(itr + 1, temp);
        }
        return array;
    }
}
