package com.kgprajwal.leetcodejavasolutions;

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        Integer maxi1 = null, maxi2 = null, maxi3 = null;
        for (Integer x : nums) {
            if (x.equals(maxi1) || x.equals(maxi2) || x.equals(maxi3)) continue;
            if (maxi1 == null || x > maxi1) {
                maxi3 = maxi2;
                maxi2 = maxi1;
                maxi1 = x;
            } else if (maxi2 == null || x > maxi2) {
                maxi3 = maxi2;
                maxi2 = x;
            } else if (maxi3 == null || x > maxi3) maxi3 = x;
        }
        return maxi3 == null ? maxi1 : maxi3;
    }
}
