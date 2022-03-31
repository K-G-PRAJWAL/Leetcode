package com.kgprajwal.leetcodejavasolutions;

public class SplitArrayLargestSum {
    public int check(int[] nums, int mid) {
        int cnt = 1, sum = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (sum + nums[i] <= mid) sum += nums[i];
            else {
                cnt++;
                sum = nums[i];
            }
        }
        return cnt;
    }

    public int splitArray(int[] nums, int m) {
        int l = 0, r = 0, mid = 0, ans = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            l = Math.max(l, nums[i]);
            r += nums[i];
        }
        while (l <= r) {
            mid = (l + r) / 2;
            int cnt = check(nums, mid);
            if (cnt <= m) {
                r = mid - 1;
                ans = mid;
            } else l = mid + 1;
        }
        return ans;
    }
}
