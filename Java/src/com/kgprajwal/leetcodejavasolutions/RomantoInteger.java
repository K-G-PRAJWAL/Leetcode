package com.kgprajwal.leetcodejavasolutions;

import java.util.HashMap;
import java.util.Map;

// O(N)
public class RomantoInteger {
    public static int romanToInt(String s) {
        Map<Character, Integer> rToi = new HashMap<>();
        rToi.put('I', 1);
        rToi.put('V', 5);
        rToi.put('X', 10);
        rToi.put('L', 50);
        rToi.put('C', 100);
        rToi.put('D', 500);
        rToi.put('M', 1000);
        int prev = 0, curr = 0, total = 0;
        for(int i=0;i<s.length();i++) {
            curr = rToi.get(s.charAt(i));
            if(curr > prev) {
                total += curr - 2*prev;
            } else {
                total += curr;
            }
            prev = curr;
        }
        return total;
    }

    // Driver
    public static void main(String[] args) {
        String s = "LXXIX";
        System.out.println(romanToInt(s));
    }
}
