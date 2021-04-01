package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        int l = 0, r = 0;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                r++;
                i++;
            }
            if (l == r) ans.add(String.valueOf(nums[l]));
            else ans.add(nums[l] + "->" + nums[r]);
            r++;
            l = r;
        }
        return ans;
    }
}
