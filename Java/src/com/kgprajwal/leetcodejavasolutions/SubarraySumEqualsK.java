package com.kgprajwal.leetcodejavasolutions;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        /*int cnt = 0;
        for(int i=0;i<nums.length;i++) {
            int sum = 0;
            for(int j=i;j<nums.length;j++) {
                sum+=nums[j];
                if(sum==k) cnt++;
            }
        }
        return cnt;*/

        int cnt = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) cnt += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}
