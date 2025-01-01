package com.kgprajwal.leetcodejavasolutions;

public class MaximumScoreAfterSplittingAString {
    public int maxScore(String s) {
        // Initial Brute force - Double-nested iteration -> O(N^2)

        // Improvement -> Count no. of zeroes on left, right part is the entire string initially. -> O(N)

        // One Pass -> score = #(zeroes on left) + #(ones on right) -> #(zeroes on left) + #(total ones) - #(ones on left)
        int zeroes = 0;
        int ones = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i< s.length(); i++) {
            if(s.charAt(i)=='0') zeroes++;
            else ones++;

            if(i!=s.length()-1)
                max = Math.max(max, zeroes - ones);
        }

        return max + ones;
    }
}
