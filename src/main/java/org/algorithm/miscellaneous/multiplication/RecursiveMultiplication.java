package org.algorithm.miscellaneous.multiplication;

public class RecursiveMultiplication extends MultiplicationHelper implements Multiplication {
    SimpleMultiplication simpleMultiplier;

    RecursiveMultiplication() {
        simpleMultiplier = new SimpleMultiplication();
    }

    public String multiplier(String var1, String var2) {
        if (var1.length() == 1 || var2.length() == 1) {
            return simpleMultiplier.multiplier(var1, var2);
        }

        if (var1.length() != var2.length()) {
            String[] res = makeOfEqualLength(var1, var2);
            var1 = res[0];
            var2 = res[1];
        }
        int size = var1.length();

        if ((size & 1) != 0) {
            var1 = paddZeroToLeft(var1, 1);
            var2 = paddZeroToLeft(var2, 1);
            size++;
        }


        String[] var1splitted = splitToHalf(var1);
        String[] var2splitted = splitToHalf(var2);
        String ac = multiplier(var1splitted[0], var2splitted[0]);
        String ad = multiplier(var1splitted[0], var2splitted[1]);
        String bc = multiplier(var1splitted[1], var2splitted[0]);
        String bd = multiplier(var1splitted[1], var2splitted[1]);
        String res = paddZeroToRight(addNumber(ad, bc), size >> 1);
        res = addNumber(res, bd);
        res = addNumber(paddZeroToRight(ac, size), res);
        return res;
    }
}
