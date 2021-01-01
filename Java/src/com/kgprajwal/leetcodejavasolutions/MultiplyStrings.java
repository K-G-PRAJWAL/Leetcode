package com.kgprajwal.leetcodejavasolutions;

public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] ans = new int[m + n];
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + ans[p2];
                ans[p1] += sum / 10;
                ans[p2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int p : ans) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("2", "3"));
    }
}
