package com.kgprajwal.leetcodejavasolutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString {
    /*
    public String reverseVowels(String s) {
        Stack<Character> stk = new Stack<Character>();
        for (char ch : s.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch=='A'|| ch=='E'|| ch=='I'|| ch=='O'|| ch=='U') stk.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch=='A'|| ch=='E'|| ch=='I'|| ch=='O'|| ch=='U') {
                sb.append(stk.pop());
            } else sb.append(ch);
        }
        return sb.toString();
    }
     */

    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r) {
            if (!set.contains(chars[l])) l++;
            else if (!set.contains(chars[r])) r--;
            else {
                char tmp = chars[l];
                chars[l] = chars[r];
                chars[r] = tmp;
                l++;
                r--;
            }
        }
        return new String(chars);
    }
}
