package com.njustxz.HuaWei;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main1{
    public static void main(String[] args){
        Scanner sca = new Scanner(System.in);
        int[] checkd = new int[32];
        Arrays.fill(checkd,0);
        while(sca.hasNext()){
            int m = sca.nextInt()-1;
            int n = sca.nextInt()-1;
            sca.nextLine();
            System.out.println(m);
            System.out.println(n);
            if(m>1023 || n>1023){
                System.out.println(-1);
                continue;
            }
            int a = m/32;
            int b = m%32;
            checkd[a]=(1<<(b-1));
            a = n/32;
            b = n%32;
            int tmp = (1<<(b-1));
            if((tmp&checkd[a])!=0){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }
}

class Main02{
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        //先求素数
        while(sca.hasNext()) {
            int tar = sca.nextInt();
            int[] isPer = new int[tar];
            Arrays.fill(isPer, 1);
            double biggest = Math.sqrt(tar);
            int allPer = tar -1;
            isPer[0] = 0;
            for (int i = 2; i < biggest; i++) {
                for (int j = i*i; j <= tar; j += i) {
                    if(isPer[j - 1] != 0) {
                        isPer[j - 1] = 0;
                        allPer--;
                    }
                }
            }
            int[] per = new int[allPer];
            int n = 0;
            for (int i = 0; i < tar; i++) {
                if (isPer[i] == 1) {
                    per[n] = i+1;
                    n++;
                }
            }
            int ret = 0;
            for (int i = allPer-1; i >0 ; i--) {
                if(per[i]*2 <tar){
                    break;
                }
                for (int j = 0; j < allPer; j++) {
                    if(per[i]+per[j] == tar){
                        ret++;
                        break;
                    }
                    if(per[i]+per[j] > tar) break;
                }
            }
            System.out.println(ret);
        }
    }
}

class Main03{
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        while(sca.hasNext()){
            int target = sca.nextInt();
            int max = 90;
            int min = -90;
            int mid;
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 6; i++) {
                mid = (max+min)/2;
                if(target >= mid){
                    sb.append('1');
                    min = mid;
                }else{
                    sb.append('0');
                    max = mid;
                }
            }
            System.out.println(sb.toString());
        }
    }
}
class Main08 {
    public static void main(String[] args){
        Scanner sca = new Scanner(System.in);
        while(sca.hasNext()){
            int n = sca.nextInt();
            int[] people = new int[n];
            int[] people1 = new int[n];
            int[] nums = new int[8];
            int[] nums1 = new int[8];
            Arrays.fill(nums,1);
            Arrays.fill(nums1,1);
            for(int i = 0;i<n;i++){
                int tp = sca.nextInt();
                people[i] = tp;
                people1[n-1-i] = tp;
            }
            queueLine(people,nums,n);
            queueLine(people1,nums1,n);
            int ret =0;
            for (int i = 0; i < n; i++) {
                int tp = nums[i]+nums1[n-1-i] -1;
                if(tp>ret) ret =tp;
            }
            System.out.println(n-ret);
        }
    }
    public static void queueLine(int[] people,int[] nums,int n){
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(people[j]<people[i]){
                    nums[i] = Math.max(nums[i],nums[j]+1);
                }
            }
        }
    }
}

class Main09{
    public static void main(String[] args) {
        
    }
}