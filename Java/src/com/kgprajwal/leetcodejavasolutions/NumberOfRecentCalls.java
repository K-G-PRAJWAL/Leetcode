package com.kgprajwal.leetcodejavasolutions;

import java.util.LinkedList;

public class NumberOfRecentCalls {
    LinkedList<Integer> window;

    public RecentCounter() {
        this.window = new LinkedList<Integer>();
    }

    public int ping(int t) {
        this.window.addLast(t);
        while (this.window.getFirst() < t - 3000) this.window.removeFirst();
        return this.window.size();
    }
}
