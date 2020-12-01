package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// O(N^3)
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n-3;i++) {
            if(i!=0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n-2;j++) {
                if(j!=i+1 && nums[j]==nums[j-1]) continue;
                int l = j+1;
                int r = n-1;
                while (l<r) {
                    int sum = nums[l]+nums[r]+nums[i]+nums[j];
                    if (sum<target) l++;
                    else if (sum>target) r--;
                    else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++; r--;
                        while(l<r && nums[l]==nums[l-1]) l++;
                        while(l<r && nums[r]==nums[r+1]) r--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,-2,2};
        int target = 0;
        System.out.println(fourSum(arr, target));
    }
}
