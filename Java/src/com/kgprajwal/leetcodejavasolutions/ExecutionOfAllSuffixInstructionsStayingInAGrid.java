package com.kgprajwal.leetcodejavasolutions;

public class ExecutionOfAllSuffixInstructionsStayingInAGrid {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] ans = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int cnt = 0;
            int[] curr = {startPos[0], startPos[1]};
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == 'L') curr[1] = curr[1] - 1;
                else if (s.charAt(j) == 'R') curr[1] = curr[1] + 1;
                else if (s.charAt(j) == 'U') curr[0] = curr[0] - 1;
                else if (s.charAt(j) == 'D') curr[0] = curr[0] + 1;

                if (curr[0] < 0 || curr[0] == n || curr[1] < 0 || curr[1] == n) break;
                cnt++;
            }
            ans[i] = cnt;
        }
        return ans;
    }
}
