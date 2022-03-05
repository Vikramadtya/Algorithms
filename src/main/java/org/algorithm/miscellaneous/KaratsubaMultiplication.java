package org.algorithm.miscellaneous;

public class KaratsubaMultiplication {
    IntegerMultiplication integerMultiplier;

    KaratsubaMultiplication() {
        integerMultiplier = new IntegerMultiplication();
    }

    private String[] splitToHalf(String var) {
        String[] result = new String[2];
        result[0] = var.substring(0, var.length() >> 1);
        result[1] = var.substring(var.length() >> 1, var.length());
        return result;
    }

    public String recursiveMultiplier(String var1, String var2) {
        if (var1.length() == 1 || var2.length() == 1) {
            return integerMultiplier.multiplyStringWithAnotherString(var1, var2);
        }

        if (var1.length() != var2.length()) {
            String[] res = integerMultiplier.makeOfEqualLength(var1, var2);
            var1 = res[0];
            var2 = res[1];
        }
        int size = var1.length();

        if ((size & 1) != 0) {
            var1 = integerMultiplier.paddZeroToLeft(var1, 1);
            var2 = integerMultiplier.paddZeroToLeft(var2, 1);
            size++;
        }


        String[] var1splitted = splitToHalf(var1);
        String[] var2splitted = splitToHalf(var2);
        String ac = recursiveMultiplier(var1splitted[0], var2splitted[0]);
        String ad = recursiveMultiplier(var1splitted[0], var2splitted[1]);
        String bc = recursiveMultiplier(var1splitted[1], var2splitted[0]);
        String bd = recursiveMultiplier(var1splitted[1], var2splitted[1]);
        String res = integerMultiplier.paddZeroToRight(integerMultiplier.addNumber(ad, bc), size >> 1);
        res = integerMultiplier.addNumber(res, bd);
        res = integerMultiplier.addNumber(integerMultiplier.paddZeroToRight(ac, size), res);
        return res;
    }
}
