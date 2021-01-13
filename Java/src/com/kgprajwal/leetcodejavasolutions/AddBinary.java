package com.kgprajwal.leetcodejavasolutions;

public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int i = a.length()-1, j = b.length()-1;
        int carry = 0;
        while(i>=0 || j>=0) {
            int sum = carry;
            if(i>=0) sum+=a.charAt(i--) - '0';
            if(j>=0) sum+=b.charAt(j--) - '0';
            ans.append(sum%2);
            carry = sum/2;
        }
        if(carry>0) ans.append(carry);
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }
}
