package com.kgprajwal.leetcodejavasolutions;

public class SortColors {
    public static void main(String[] args) {
        SortColors s = new SortColors();
        s.sortColors(new int[]{2,0,2,1,1,0});
    }

    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = nums.length-1;
        while (white<=blue) {
            if(nums[white]==0) {
                swap(nums, red, white);
                white+=1;
                red+=1;
            } else if(nums[white]==1) white+=1;
            else {
                swap(nums, white, blue);
                blue-=1;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
