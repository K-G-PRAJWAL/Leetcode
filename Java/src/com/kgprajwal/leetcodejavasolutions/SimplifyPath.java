package com.kgprajwal.leetcodejavasolutions;

import java.util.*;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        StringBuilder ans = new StringBuilder("/");
        LinkedList<String> stk = new LinkedList<>();
        for (String s : path.split("/")) {
            if (s.equals("..")) {
                if (!stk.isEmpty())
                    stk.removeLast();
            } else if (!s.equals("") && !s.equals("."))
                stk.add(s);
        }
        for (String s : stk)
            ans.append(s + "/");
        if (!stk.isEmpty()) ans.setLength(ans.length() - 1);
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/./b/../../c/"));
    }
}
