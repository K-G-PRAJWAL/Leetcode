package com.kgprajwal.leetcodejavasolutions;

// O(N)
public class StringtoInteger {
    public static int myAtoi(String s) {
        int i = 0;
        int sign = 1;
        int ans = 0;
        if(s.length()==0) return 0;
        while(i<s.length() && s.charAt(i)==' ') {
            i++;
        }
        if(i<s.length() && (s.charAt(i)=='+' || s.charAt(i)=='-')) sign = (s.charAt(i++)=='-') ? -1 : 1;
        while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9') {
            if(ans>Integer.MAX_VALUE/10 || (ans==Integer.MAX_VALUE/10 && s.charAt(i)-'0' > Integer.MAX_VALUE%10)) {
                return (sign==1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans*10+(s.charAt(i++)-'0');
        }
        return ans*sign;
    }

    // Driver
    public static void main(String[] args) {
        String s = "42";
        System.out.println(myAtoi(s));
    }
}