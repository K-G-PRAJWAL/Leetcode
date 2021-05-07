package com.kgprajwal.leetcodejavasolutions;

public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        int l = 1, h = n;
        while (l <= h) {
            int mid1 = l + (h - l) / 3;
            int mid2 = h - (h - l) / 3;
            int ans1 = guess(mid1);
            int ans2 = guess(mid2);
            if (ans1 == 0) return mid1;
            if (ans2 == 0) return mid2;
            else if (ans1 < 0) h = mid1 - 1;
            else if (ans2 > 0) l = mid2 + 1;
            else {
                l = mid1 + 1;
                h = mid2 - 1;
            }
        }
        return -1;
    }
}
