package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean divBy3 = i % 3 == 0;
            boolean divBy5 = i % 5 == 0;
            String s = "";
            if (divBy3) s += "Fizz";
            if (divBy5) s += "Buzz";
            if (s.equals("")) s += Integer.toString(i);
            answer.add(s);
        }
        return answer;
    }
}
