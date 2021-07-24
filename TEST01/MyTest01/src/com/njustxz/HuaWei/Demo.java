package com.njustxz.HuaWei;


public class Demo {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(getCount(nums, 18));
    }

    public static int getCount(int[][] nums,int t){
        if(nums==null || nums.length<1 || nums[0].length<1 || nums[0][0]>t)
            return -1;
        int n = nums.length;
        int m = nums[0].length;
        int[][] dp = new int[n+1][m+1];
        for(int i =0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0||j==0){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = Math.min(dp[i-1][j]+nums[i-1][j-1],dp[i][j-1]+nums[i-1][j-1]);
                }
            }
        }

        if(dp[n][m]>t){
            return -1;
        }else{
            return dp[n][m];
        }
    }
}
