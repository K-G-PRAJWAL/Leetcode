package com.kgprajwal.leetcodejavasolutions;

// O(N)
public class IntegertoRoman {
    public static String intToRoman(int num) {
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] vals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder ans = new StringBuilder();
        for(int i=0;i< vals.length;i++) {
            while(num>=vals[i]) {
                num -= vals[i];
                ans.append(romans[i]);
            }
        }
        return ans.toString();
    }

    // Driver
    public static void main(String[] args) {
        Integer a = 899;
        System.out.println(intToRoman(a));
    }
}
