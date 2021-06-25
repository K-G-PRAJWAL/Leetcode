package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;

public class KidsWithGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < candies.length; i++) max = Math.max(max, candies[i]);
        max = max - extraCandies;
        for (int i = 0; i < candies.length; i++) ans.add(candies[i] >= max);
        return ans;
    }
}
