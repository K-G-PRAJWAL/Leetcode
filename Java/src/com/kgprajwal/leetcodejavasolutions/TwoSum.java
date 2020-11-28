package com.kgprajwal.leetcodejavasolutions;

import java.util.HashMap;
import java.util.Map;

// O(N)
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (map.containsKey(difference)) {
                return new int[]{map.get(difference), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, 1};
    }

    // Driver
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int[] ans = twoSum(arr, 9);
        for (int i=0;i<ans.length;i++)
            System.out.println(ans[i]);
    }
}
