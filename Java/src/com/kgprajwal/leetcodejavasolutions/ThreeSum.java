package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// O(N^2)
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i+1, r = nums.length-1;
            int target = -nums[i];
            while (l<r) {
                if(nums[l]+nums[r] < target) {
                    l++;
                } else if(nums[l]+nums[r] > target) {
                    r--;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++; r--;
                    while(l<r && nums[l]==nums[l-1]) l++;
                    while(l<r && nums[r]==nums[r+1]) r--;
                }
            }
        }
        return ans;
    }

    // Driver
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(arr));
    }
}
