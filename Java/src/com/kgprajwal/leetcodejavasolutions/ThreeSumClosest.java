package com.kgprajwal.leetcodejavasolutions;

import java.util.Arrays;

// O(N^2)
public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int l, r, currSum, ans = nums[0]+nums[1]+nums[2];
        for(int i=0;i<n;i++) {
            l = i+1;
            r = n-1;
            while(l<r) {
                currSum = nums[i]+nums[l]+nums[r];
                if(Math.abs(currSum-target) < Math.abs(ans-target))
                    ans = currSum;
                if(currSum < target)
                    l++;
                else
                    r--;
            }
        }
        return ans;
    }

    // Driver
    public static void main(String args[]) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }
}
