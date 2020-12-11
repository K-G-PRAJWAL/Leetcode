package com.kgprajwal.leetcodejavasolutions;

public class CountandSay {
    public static String countAndSay(int n) {
        if(n==0) return "";
        String ans = "1";
        while(n>1) {
            StringBuilder curr = new StringBuilder();
            for(int i=0;i<ans.length();i++) {
                int cnt = 1;
                while(i+1 < ans.length() && ans.charAt(i)==ans.charAt(i+1)) {
                    cnt++;
                    i++;
                }
                curr.append(cnt).append(ans.charAt(i));
            }
            ans = curr.toString();
            n--;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
}
