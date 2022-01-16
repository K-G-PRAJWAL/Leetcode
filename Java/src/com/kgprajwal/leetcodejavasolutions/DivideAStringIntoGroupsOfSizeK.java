package com.kgprajwal.leetcodejavasolutions;

public class DivideAStringIntoGroupsOfSizeK {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int toFill = n % k == 0 ? 0 : (k - n % k);
        StringBuilder sb = new StringBuilder(s);
        while (toFill-- > 0) {
            sb.append(fill);
        }
        String[] res = new String[sb.length() / k];
        int i = 0;
        while (i < res.length) {
            res[i] = sb.substring(i * k, i * k + k);
            i++;
        }
        return res;
    }
}
