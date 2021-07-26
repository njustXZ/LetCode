package com.njustxz.LeetCodeOffer;

import java.util.*;

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


    //1743.从相邻元素还原数组
    public static int[] restoreArray(int[][] adjacentPairs) {
        if(adjacentPairs==null || adjacentPairs.length==0 ){
            return null;
        }
        Map<Integer,Integer> numsPairs = new HashMap<>();
        Set<Integer> head = new HashSet<>();
        for (int[] adjacentPair : adjacentPairs) {
            if(numsPairs.containsKey(adjacentPair[0])){
                numsPairs.put(adjacentPair[1], adjacentPair[0]);
            }else{
                numsPairs.put(adjacentPair[0], adjacentPair[1]);
            }

            for (int j = 0; j < 2; j++) {
                if (head.contains(adjacentPair[j])) {
                    head.remove(adjacentPair[j]);
                } else {
                    head.add(adjacentPair[j]);
                }
            }
        }
        int n = adjacentPairs.length+1;
        int[] ret = new int[n];
        for(int num:head){
            if(numsPairs.containsKey(num)){
                ret[0]=num;
                break;
            }
        }
        for (int i = 1; i < n; i++) {
            ret[i] = numsPairs.get(ret[i-1]);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] nums = new int[3][2];
        nums[0][0] = 2;
        nums[0][1] = 1;
        nums[1][0] = 3;
        nums[1][1] = 4;
        nums[2][0] = 3;
        nums[2][1] = 2;
        int[] ans = restoreArray(nums);
        System.out.println(ans);
    }
}

