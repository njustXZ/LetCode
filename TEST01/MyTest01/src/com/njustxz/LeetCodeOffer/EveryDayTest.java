package com.njustxz.LeetCodeOffer;

public class EveryDayTest {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if(n<3) return false;
        int min = nums[0],big=nums[0],med;
        boolean findBig=false;
        for (int i = 1; i < n; i++) {
            int tmp = nums[i];
            if(tmp < min){
                min = tmp;
                findBig = false;
            }else if(!findBig){
                big = tmp;
                findBig = true;
            }else if(big<tmp){
                big=tmp;
            }else if(tmp == min||tmp==big){
            }else{
                return true;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length==0||matrix[0].length == 0) return false;
        int m = matrix.length,n = matrix[0].length;
        int i=0,j=n-1;
        while(i<m-1 && j>=0){
            if(matrix[i][j]==target) return true;
            if (matrix[i][j] < target) {
                ++i;
            } else {
                --j;
            }
        }
        return false;
    }
}

