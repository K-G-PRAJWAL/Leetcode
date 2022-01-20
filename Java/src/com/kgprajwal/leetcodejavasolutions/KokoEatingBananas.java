package com.kgprajwal.leetcodejavasolutions;

public class KokoEatingBananas {
    // Brute force
    /* public int minEatingSpeed(int[] piles, int h) {
        int currSpeed = 1;
        while (true) {
            int currHours = 0;
            for (int pile : piles) {
                currHours += Math.ceil((double) pile / currSpeed);
                if (currHours > h) break;
            }
            if (currHours <= h) return currSpeed;
            else currSpeed++;
        }
    } */

    // Efficient - Binary Search
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 1;
        for (int pile : piles) r = Math.max(r, pile);
        while (l < r) {
            int m = (l + r) / 2;
            int currHours = 0;
            for (int pile : piles) currHours += Math.ceil((double) pile / m);
            if (currHours <= h) r = m;
            else l = m + 1;
        }
        return r;
    }
}
