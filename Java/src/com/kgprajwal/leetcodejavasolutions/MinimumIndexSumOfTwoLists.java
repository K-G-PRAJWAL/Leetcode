package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.HashMap;

public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int idx = map.get(list2[i]);
                if (idx + i < minSum) {
                    minSum = idx + i;
                    ans = new ArrayList<>();
                    ans.add(list2[i]);
                } else if (idx + i == minSum) ans.add(list2[i]);
            }
        }
        String[] res = new String[ans.size()];
        return ans.toArray(res);
    }
}
