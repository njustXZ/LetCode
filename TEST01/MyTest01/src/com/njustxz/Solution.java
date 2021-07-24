package com.njustxz;

import javax.xml.transform.Source;
import java.util.*;


public class Solution {

    public int NS_LIS (String n) {
        // write code here
        int len = n.length();
        if(len==1){
            return Integer.parseInt(n);
        }
        String str = n.substring(0,2);
        int before = Integer.parseInt(str);
        int first = before/10;
        int second = before%10;
        int ret = 0;
        if(second==9){
            ret = first+second;
            ret = ret+9*(len-2);
            for(int i = 2;i<len;i++){
                char tmp = n.charAt(i);
                if(tmp!='9'){
                    ret=ret-1;
                    break;
                }
            }
        }else{
            ret = first+8;
            ret = ret+9*(len-2);
        }
        return ret;
    }


    public int[] Magical_NN (int[] h) {
        // write code here
        Map<Integer,Integer> sum = new HashMap<>();
        Map<Integer,Integer> ans = new HashMap<>();
        for(int i:h){
            if(sum.containsKey(i)){
                sum.put(i,sum.get(i)+1);
            }else{
                sum.put(i,1);
            }
        }
        for(int i:sum.keySet()){
            int tmp =0;
            for(int j:sum.keySet()){
                int tp = i-j;
                if(tp>0){
                    tmp = tmp+tp*sum.get(j);
                }else{
                    tmp = tmp-tp*sum.get(j);
                }
            }
            ans.put(i,tmp);
        }
        int[] ret = new int[h.length];
        for(int i = 0;i<h.length;i++){
            ret[i] = ans.get(h[i]);
        }
        return ret;
    }
    public static void main(String[] args) {
        Solution s1 = new Solution();
        /*System.out.println(s1.NS_LIS("199982"));*/
        int[] test = {3,1,4,5,3};
        for(int num:s1.Magical_NN(test)){
            System.out.println(num);
        }
    }

    public static void m1() {
        
    }
}