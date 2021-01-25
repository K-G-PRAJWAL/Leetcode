package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        backtracker(ans, "", s, 0);
        return ans;
    }

    void backtracker(List<String> result, String path, String s, int k) {
        if (s.isEmpty() || k == 4) {
            if (s.isEmpty() && k == 4)
                result.add(path.substring(1));
            return;
        }
        for (int i = 1; i <= (s.charAt(0) == '0' ? 1 : 3) && i <= s.length(); i++) { // Avoid leading 0
            String part = s.substring(0, i);
            if (Integer.valueOf(part) <= 255)
                backtracker(result, path + "." + part, s.substring(i), k + 1);
        }
    }

    public static void main(String[] args) {
        RestoreIPAddresses r = new RestoreIPAddresses();
        System.out.println(r.restoreIpAddresses("25525511135"));
    }
}
