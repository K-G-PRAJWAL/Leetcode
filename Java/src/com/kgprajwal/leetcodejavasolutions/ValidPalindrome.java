package com.kgprajwal.leetcodejavasolutions;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) return true;
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            char cL = s.charAt(l);
            char cR = s.charAt(r);
            if (!Character.isLetterOrDigit(cL)) l++;
            else if (!Character.isLetterOrDigit(cR)) r--;
            else {
                if (Character.toLowerCase(cL) != Character.toLowerCase(cR)) return false;
                l++;
                r--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome o = new ValidPalindrome();
        System.out.println(o.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
