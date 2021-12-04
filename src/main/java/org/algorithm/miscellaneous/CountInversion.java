package org.algorithm.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiPredicate;

public class CountInversion {

    public static void main(String[] args) {
        List<Integer> merged = new ArrayList<Integer>(Arrays.asList(1, 5, 3, 4));

        CountInversion inversionCounter = new CountInversion();

        HashMap<String, Object> res = inversionCounter.<Integer>getInversions(merged, (Integer a, Integer b) -> {
            if (a < b)
                return true;
            return false;
        });

        System.out.println(res.get("count"));

    }

    public <E> HashMap<String, Object> splitInversion(List<E> left, List<E> right, BiPredicate<E, E> comparator) {
        int inversions = 0;
        List<E> merged = new ArrayList<E>();
        int i = 0, j = 0;
        for (; i < left.size() && j < right.size(); ) {
            if (comparator.test(left.get(i), right.get(j))) {
                merged.add(left.get(i++));
            } else {
                merged.add(right.get(j++));
                inversions += left.size() - i;
            }
        }

        for (; i < left.size(); ++i)
            merged.add(left.get(i));

        for (; j < right.size(); ++j)
            merged.add(right.get(j));

        HashMap<String, Object> pair = new HashMap<>();
        pair.put("count", Integer.valueOf(inversions));
        pair.put("array", merged);
        return pair;
    }

    @SuppressWarnings("unchecked")
    public <A> HashMap<String, Object> getInversions(List<A> array, BiPredicate<A, A> comparator) {

        if (array.size() == 1 || array.size() == 0) {
            HashMap<String, Object> pair = new HashMap<>();
            pair.put("count", 0);
            pair.put("array", array);
            return pair;
        }

        List<A> left = array.subList(0, array.size() >> 1);
        List<A> right = array.subList(array.size() >> 1, array.size());
        HashMap<String, Object> leftInversions = getInversions(left, comparator);
        HashMap<String, Object> rightInversions = getInversions(right, comparator);
        HashMap<String, Object> merged = splitInversion((List<A>) leftInversions.get("array"),
                (List<A>) rightInversions.get("array"), comparator);

        merged.replace("count", (Integer) merged.get("count") + (Integer) leftInversions.get("count")
                + (Integer) rightInversions.get("count"));
        return merged;

    }

}
