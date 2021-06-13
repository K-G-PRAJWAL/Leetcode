package com.kgprajwal.leetcodejavasolutions;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        int ans = 0;
        Set JewelsSet = new HashSet();
        for (char jewel : jewels.toCharArray()) JewelsSet.add(jewel);
        for (char stone : stones.toCharArray())
            if (JewelsSet.contains(stone)) ans++;
        return ans;
    }
}
