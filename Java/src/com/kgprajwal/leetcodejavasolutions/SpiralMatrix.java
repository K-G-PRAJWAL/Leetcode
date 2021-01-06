package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if(matrix.length==0) return ans;
        int rowStart = 0, colStart = 0;
        int rowEnd = matrix.length-1, colEnd = matrix[0].length-1;
        while(rowStart<=rowEnd && colStart<=colEnd) {
            for(int col=colStart; col<=colEnd; col++) {
                ans.add(matrix[rowStart][col]);
            }
            for(int row=rowStart+1; row<=rowEnd; row++) {
                ans.add(matrix[row][colEnd]);
            }
            if(rowStart<rowEnd && colStart<colEnd) {
                for(int col=colEnd-1; col>colStart;col--) {
                    ans.add(matrix[rowEnd][col]);
                }
                for(int row=rowEnd;row>rowStart;row--) {
                    ans.add(matrix[row][colStart]);
                }
            }
            rowStart++;
            rowEnd--;
            colStart++;
            colEnd--;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        }));
    }
}
