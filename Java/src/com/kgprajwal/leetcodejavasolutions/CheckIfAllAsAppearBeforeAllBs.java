package com.kgprajwal.leetcodejavasolutions;

public class CheckIfAllAsAppearBeforeAllBs {
    // Alternate solution
    public boolean checkString2(String s) {
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') flag = true;
            else if (flag == true) return false;
        }
        return true;
    }

    public boolean checkString(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') {
                for (int j = i; j < s.length(); j++)
                    if (s.charAt(j) == 'a') return false;
            }
        }
        return true;
    }
}
