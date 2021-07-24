package com.njustxz.ByteDance;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sca = new Scanner(System.in);
        while(sca.hasNext()){
            String tmp = sca.nextLine();
            String[] nums = tmp.split(" ");
            int n = Integer.parseInt(nums[0]);
            int[] n1 = new int[n];
            int[] n2 = new int[n];
            int[] n3 = new int[n];
            int[] n4 = new int[n];
            int ret=0;
            tmp = sca.nextLine();
            nums = tmp.split(" ");
            for(int i=0;i<n;i++){
                n1[i] = Integer.parseInt(nums[i]);
            }
            tmp = sca.nextLine();
            nums = tmp.split(" ");
            for(int i=0;i<n;i++){
                n2[i] = Integer.parseInt(nums[i]);
                n3[i] = 2*n2[i]+n1[i];
            }
            n4[0]=n3[0];
            if(n4[0]!=0) ret++;
            for(int i=1;i<n;i++){
                if(n3[i]!=0){
                    if(n4[i-1]==0 ||n4[i-1]==3){
                        ret++;
                        n4[i]=n3[i];
                    }else if(n3[i]!=n4[i-1]){
                        ret++;
                        if(n3[i]==3){
                            n4[i]=n3[i]-n4[i-1];
                        }else {
                            n4[i] = n3[i];
                        }
                    }
                }
            }
            System.out.println(ret);
        }
    }
}
