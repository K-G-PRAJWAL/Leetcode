package com.kgprajwal.leetcodejavasolutions;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        result.append(sign);
        result.append(num / den);
        long rem = num % den;
        if (rem == 0)
            return result.toString();
        result.append(".");
        Map<Long, Integer> map = new HashMap();
        while (rem != 0) {
            if (!map.containsKey(rem)) {
                map.put(rem, result.length());
            } else {
                int idx = map.get(rem);
                return result.substring(0, idx) + "(" + result.substring(idx) + ")";
            }
            rem *= 10;
            result.append(rem / den);
            rem = rem % den;
        }
        return result.toString();
    }
}
