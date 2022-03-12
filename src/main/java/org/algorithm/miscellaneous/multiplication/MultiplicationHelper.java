package org.algorithm.miscellaneous.multiplication;

public abstract class MultiplicationHelper {
    public int charToInt(char x) {
        return x - '0';
    }

    /**
     * Multiply a number with 1 digit
     *
     * @param var
     * @param x
     * @return
     */
    public String multiplyStringWithOneValue(String var, char x) {
        int carry = 0;
        StringBuilder result = new StringBuilder();
        for (int i = var.length() - 1; i >= 0; --i) {
            int product = charToInt(var.charAt(i)) * charToInt(x) + carry;
            result.append(product % 10);
            carry = product / 10;
        }
        result.append(carry != 0 ? carry : "");
        return result.reverse().toString();
    }

    /**
     * Add two number
     *
     * @param var1
     * @param var2
     * @return
     */
    public String addNumber(String var1, String var2) {
        int size = Math.max(var1.length(), var2.length());
        if (var1.length() != var2.length()) {
            var1 = (var1.length() < var2.length()) ? paddZeroToLeft(var1, var2.length() - var1.length()) : var1;
            var2 = (var2.length() < var1.length()) ? paddZeroToLeft(var2, var1.length() - var2.length()) : var2;
        }
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = size - 1; i >= 0; --i) {
            int sum = charToInt(var1.charAt(i)) + charToInt(var2.charAt(i)) + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }
        if (carry != 0) result.append(carry);
        return result.reverse().toString();
    }

    /**
     * Padd the number with '0' at the right e.g 123 -> 123000
     *
     * @param var
     * @param padding
     * @return
     */
    public String paddZeroToLeft(String var, int padding) {
        StringBuilder res = new StringBuilder();
        res.append(new String(new char[padding]).replace("\0", "0"));
        res.append(var);
        return res.toString();
    }

    /**
     * Padd the number with '0' at the right e.g 123 -> 123000
     *
     * @param var
     * @param padding
     * @return
     */
    public String paddZeroToRight(String var, int padding) {
        StringBuilder res = new StringBuilder(var);
        res.append(new String(new char[padding]).replace("\0", "0"));
        return res.toString();
    }

    public String[] makeOfEqualLength(String var1, String var2) {
        String[] res = {var1, var2};
        if (var1.length() == var2.length())
            return res;
        res[0] = (var1.length() < var2.length()) ? paddZeroToLeft(var1, var2.length() - var1.length()) : var1;
        res[1] = (var2.length() < var1.length()) ? paddZeroToLeft(var2, var1.length() - var2.length()) : var2;
        return res;
    }

    public String[] splitToHalf(String var) {
        String[] result = new String[2];
        result[0] = var.substring(0, var.length() >> 1);
        result[1] = var.substring(var.length() >> 1, var.length());
        return result;
    }

    public String[] makeOfEqualAndEvenLength(String var1, String var2) {
        String[] res = {var1, var2};

        if (var1.length() != var2.length()) {
            res = makeOfEqualLength(var1, var2);
        }

        int size = var1.length();

        if ((size & 1) != 0) {
            res[0] = paddZeroToLeft(res[0], 1);
            res[1] = paddZeroToLeft(res[1], 1);
        }
        return res;
    }
}
