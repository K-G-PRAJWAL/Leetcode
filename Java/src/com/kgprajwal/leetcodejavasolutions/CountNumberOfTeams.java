package com.kgprajwal.leetcodejavasolutions;

public class CountNumberOfTeams {
    public int numTeams(int[] rating) {
        int cnt = 0;
        int n = rating.length;
        for (int i = 0; i < n; i++) {
            int leftSmall = 0, rightLarge = 0;
            int leftLarge = 0, rightSmall = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) leftSmall++;
                else if (rating[j] > rating[i]) leftLarge++;
            }
            for (int k = i + 1; k < n; k++) {
                if (rating[i] < rating[k]) rightLarge++;
                else if (rating[i] > rating[k]) rightSmall++;
            }
            cnt += leftSmall * rightLarge + leftLarge * rightSmall;
        }
        return cnt;
    }
}
