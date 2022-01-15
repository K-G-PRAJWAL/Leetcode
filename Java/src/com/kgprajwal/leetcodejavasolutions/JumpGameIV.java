package com.kgprajwal.leetcodejavasolutions;

import java.util.*;

public class JumpGameIV {
    public int minJumps(int[] arr) {
        int n = arr.length;
        HashMap<Integer, List<Integer>> map = new HashMap();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        Set<Integer> visited = new HashSet();
        visited.add(0);
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int cnt = 0;
        while (!q.isEmpty()) {
            int l = q.size();
            for (int i = 0; i < l; i++) {
                int val = q.poll();
                if (val == n - 1) return cnt;
                if (val > 0 && visited.add(val - 1)) q.add(val - 1);
                if (val < n - 1 && visited.add(val + 1)) q.add(val + 1);
                if (map.containsKey(arr[val])) {
                    for (int idx : map.get(arr[val])) {
                        if (visited.add(idx)) q.add(idx);
                    }
                }
                map.remove(arr[val]);
            }
            cnt++;
        }
        return -1;
    }
}
