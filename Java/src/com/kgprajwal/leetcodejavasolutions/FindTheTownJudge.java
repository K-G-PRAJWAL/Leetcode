package com.kgprajwal.leetcodejavasolutions;

public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] cnt = new int[n];
        for(int i=0;i<trust.length;i++) {
            // trusts a person - indegree decreased
            cnt[trust[i][0]-1]--;
            // person gets trusted - indegree increased
            cnt[trust[i][1]-1]++;
        }
        for(int i=0;i<n;i++) {
            if(cnt[i]==n-1) return i+1;
        }
        return -1;
    }
}
