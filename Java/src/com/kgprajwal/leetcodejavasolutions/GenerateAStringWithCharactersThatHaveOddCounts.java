package com.kgprajwal.leetcodejavasolutions;

import java.util.Arrays;

public class GenerateAStringWithCharactersThatHaveOddCounts {
    public String generateTheString(int n) {
        char[] ans = new char[n];
        Arrays.fill(ans, 'a');
        if (n % 2 == 0) ans[0] = 'b';
        return new String(ans);
    }
}
