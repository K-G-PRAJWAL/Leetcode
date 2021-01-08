package com.kgprajwal.leetcodejavasolutions;

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        int n = s.length();
        int ans = 0;
        while(n > 0 && s.charAt(n-1)==' ') n--;
        while(n>0 && s.charAt(n-1)!=' ') {
            n--;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
    }
}
