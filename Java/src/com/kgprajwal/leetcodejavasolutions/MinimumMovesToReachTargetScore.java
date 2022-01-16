package com.kgprajwal.leetcodejavasolutions;

public class MinimumMovesToReachTargetScore {
    public int minMoves(int target, int maxDoubles) {
        int cnt = 0;
        while (target > 0 && maxDoubles > 0) {
            if (target % 2 == 0) {
                target /= 2;
                maxDoubles--;
            } else target--;
            cnt++;
        }
        return cnt + target - 1;
    }
}
