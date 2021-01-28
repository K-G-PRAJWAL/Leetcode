package com.kgprajwal.leetcodejavasolutions;

public class InterleavingString {
    // METHOD 1 - Recursion
//    public boolean isInterleave(String s1, String s2, String s3) {
//        return helper(s1, 0, s2, 0, "", s3);
//    }
//
//    boolean helper(String s1, int i, String s2, int j, String ans, String s3) {
//        if(s3.equals(ans) && i==s1.length() && j==s2.length()) return true;
//        boolean res = false;
//        if(i<s1.length())
//            res|=helper(s1, i+1, s2, j, ans+s1.charAt(i), s3);
//        if(j<s2.length())
//            res|=helper(s1, i, s2, j+1, ans+s2.charAt(j), s3);
//        return res;
//    }

    // METHOD 2 - Recursion+Memoization
//    public boolean isInterleave(String s1, String s2, String s3) {
//        int memo[][] = new int[s1.length()][s2.length()];
//        for(int i=0;i<s1.length();i++) {
//            for(int j=0;j<s2.length();j++) {
//                memo[i][j] = -1;
//            }
//        }
//        return helper(s1, 0, s2, 0, s3, 0, memo);
//    }
//
//    boolean helper(String s1, int i, String s2, int j, String s3, int k, int[][] memo) {
//        if(i==s1.length()) return s2.substring(j).equals(s3.substring(k));
//        if(j==s2.length()) return s1.substring(i).equals(s3.substring(k));
//        if(memo[i][j]>=0) return memo[i][j]==1 ? true : false;
//        boolean ans = false;
//        if(s1.charAt(i)==s3.charAt(k) && helper(s1, i+1, s2, j, s3, k+1, memo) || (s2.charAt(j)==s3.charAt(k) && helper(s1, i, s2, j+1, s3, k+1, memo))) ans = true;
//        memo[i][j] = ans ? 1 : 0;
//        return ans;
//    }

    // METHOD 3 - DP - 1D
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length())
            return false;
        boolean dp[] = new boolean[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[j] = true;
                } else if (i == 0) {
                    dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        InterleavingString i = new InterleavingString();
        System.out.println(i.isInterleave(s1, s2, s3));
    }
}
