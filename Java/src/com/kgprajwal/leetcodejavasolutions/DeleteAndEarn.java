package com.kgprajwal.leetcodejavasolutions;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int[] cnt = new int[10001];

        for (int n : nums)
            cnt[n] += n;

        int take = 0, skip = 0;
        for (int i = 0; i < 10001; i++) {
            int new_take = cnt[i] + skip;
            int new_skip = Math.max(skip, take);
            take = new_take;
            skip = new_skip;
        }
        return Math.max(take, skip);
    }
}
