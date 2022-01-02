package com.kgprajwal.leetcodejavasolutions;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] hash = new int[60];
        int ans = 0;
        // Count number of songs having a common % 60 time in an array a.k.a their frequency
        for (int i = 0; i < time.length; i++) {
            int mod = time[i] % 60;
            hash[mod]++;
        }
        for (int i = 0; i <= 30; i++) {
            if (i == 0 || i == 30) { // requires no pairing if present in hash
                int freq = hash[i];
                ans += (freq * (freq - 1) / 2);
            } else ans += hash[i] * hash[60 - i];
        }
        return ans;
    }
}
