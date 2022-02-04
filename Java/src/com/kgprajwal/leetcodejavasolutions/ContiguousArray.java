package com.kgprajwal.leetcodejavasolutions;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0, cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt += nums[i] == 1 ? 1 : -1;
            if (map.containsKey(cnt)) {
                max = Math.max(max, i - map.get(cnt));
            } else map.put(cnt, i);
        }
        return max;
    }
}
