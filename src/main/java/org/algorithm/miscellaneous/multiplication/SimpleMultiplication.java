package org.algorithm.miscellaneous.multiplication;

import org.algorithm.miscellaneous.multiplication.Multiplication;
import org.algorithm.miscellaneous.multiplication.MultiplicationHelper;

public class SimpleMultiplication extends MultiplicationHelper implements Multiplication {
    /**
     * Multiply two number
     *
     * @param var1
     * @param var2
     * @return
     */
    public String multiplier(String var1, String var2) {
        String res = "0";
        for (int i = var1.length() - 1; i >= 0; --i) {
            String intermediate = multiplyStringWithOneValue(var2, var1.charAt(i));
            res = addNumber(res, paddZeroToRight(intermediate, var1.length() - 1 - i));
        }
        return res.toString();
    }
}
