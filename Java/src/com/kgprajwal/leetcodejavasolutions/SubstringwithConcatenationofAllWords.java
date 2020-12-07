package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {
    public static List<Integer> findSubstring(String s, String[] words) {
        if(s==null || s.length()==0 || words.length==0) return new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for(String word: words) map.put(word, map.getOrDefault(word, 0)+1);

        int l = words[0].length();
        int n = words.length;
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<=s.length()-n*l;i++) {
            Map<String, Integer> seen = new HashMap<>();
            for(int j=0;j<n;j++) {
                int idx = i+j*l;
                String word = s.substring(idx, idx+l);
                if(!map.containsKey(word)) break;
                seen.put(word, seen.getOrDefault(word, 0)+1);
                if(seen.get(word)>map.getOrDefault(word, 0)) break;
                if(j+1==n) ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] arr = {"foo","bar"};
        System.out.println(findSubstring(s, arr));
    }
}
