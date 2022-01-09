package com.kgprajwal.leetcodejavasolutions;

public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        if (instructions.length() == 0) return false;
        int x = 0, y = 0;
        char dir = 'N';
        for (char ch : instructions.toCharArray()) {
            if (ch == 'G') {
                if (dir == 'N') y += 1;
                else if (dir == 'S') y -= 1;
                else if (dir == 'E') x += 1;
                else x -= 1;
            } else if (ch == 'L') {
                if (dir == 'N') dir = 'W';
                else if (dir == 'W') dir = 'S';
                else if (dir == 'S') dir = 'E';
                else dir = 'N';
            } else if (ch == 'R') {
                if (dir == 'N') dir = 'E';
                else if (dir == 'E') dir = 'S';
                else if (dir == 'S') dir = 'W';
                else dir = 'N';
            }
        }
        if (x == 0 && y == 0) return true;
        if (dir == 'N') return false;
        return true;
    }
}
