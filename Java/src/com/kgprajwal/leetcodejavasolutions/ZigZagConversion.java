package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;

// O(N)
public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        if (numRows==1)
            return s;
        List<StringBuilder> row = new ArrayList<>();
        for(int i = 0;i<numRows;i++) {
            row.add(new StringBuilder());
        }
        int curr = 0;
        boolean down = false;
        for(char c: s.toCharArray()) {
            row.get(curr).append(c);
            if(curr==0 || curr==numRows-1) {
                down = !down;
            }
            curr += down ? 1 : -1;
        }
        StringBuilder ans = new StringBuilder();
        for(StringBuilder r: row)
            ans.append(r);
        return ans.toString();
    }

    // Driver
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        String ans = convert(s, 3);
        System.out.println(ans);
    }
}
