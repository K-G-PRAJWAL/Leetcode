package com.kgprajwal.leetcodejavasolutions;

// O(log(N))
public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        int rvr = 0;
        int temp = x;
        int rem = 0;
        while(x>0) {
            rem = x%10;
            x/=10;
            rvr = rvr*10+rem;
        }
        return rvr==temp;
    }

    // Driver
    public static void main(String[] args) {
        PalindromeNumber p = new PalindromeNumber();
        System.out.println(p.isPalindrome(12321));
    }
}