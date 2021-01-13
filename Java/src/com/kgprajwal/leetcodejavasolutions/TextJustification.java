package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static List<String> justify(String words[], int maxWidth) {
        List<String> res = new ArrayList<>();
        int i=0;
        while (i<words.length){
            int width=0, I=i;
            while (I<words.length && width+words[I].length()+(I-i)<=maxWidth)
                width+=words[I++].length();
            int space=1, extra=0;
            if (I-i!=1 && I!=words.length){
                space=(maxWidth-width)/(I-i-1);
                extra=(maxWidth-width)%(I-i-1);
            }
            StringBuilder line= new StringBuilder(words[i++]);
            while (i<I){
                for (int s= space; s>0; s--) line.append(" ");
                if (extra-->0) line.append(" ");
                line.append(words[i++]);
            }
            for (int s= maxWidth-line.length(); s>0; s--) line.append(" ");
            res.add(line.toString());
        }
        return res;
    }

    public static void main(String args[]){
        String words[] = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        System.out.println(justify(words, 20));
    }
}
