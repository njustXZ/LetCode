package com.njustxz.Tree;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Test {
    //224.基础计算器
    //3.无重复字符串的最长子字符串
    public int lengthOfLongestSubstring(String s) {
        //前后指针出错

        //使用数组来存储每个字符最后出现的位置
        //两个位置相减最大的就是非重复的最长子串了
        int[] last = new int[128];
        Arrays.fill(last,-1);
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            res = Math.max(res,i-last[index]);
            last[index] = i;
        }
        return res;
        //后面依据题解，使用哈希set
        /*Set<Character> hasSet = new HashSet<>();
        int n = s.length();
        int end = -1, ans=0;
        for (int i = 0; i < n; ++i) {
            if(i>0){
                hasSet.remove(s.charAt(i-1));
            }
            while (end+1 <n && !hasSet.contains(s.charAt(end+1))){
                hasSet.add(s.charAt(end+1));
                end++;
            }
            ans=Math.max(ans,end - i+1);
        }
        return ans;*/
    }

    //1047 删除字符串所有相邻重复项
    public String removeDuplicates(String s){
        Stack<Character> s1 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s1.empty() || s.charAt(i)!=s1.peek()){
                s1.push(s.charAt(i));
            }else{
                s1.pop();
            }
        }
        StringBuffer sb = new StringBuffer();
        for(Character c :s1){
            sb.append(c);
        }
        return sb.toString();

       /* StringBuffer sb = new StringBuffer(s);
        int n=sb.length();
        int i=0;
        while(i<n-1){
            for(i=0;i<n-1;i++){
                if(sb.charAt(i)==sb.charAt(i+1)){
                    sb.delete(i-1,i+1);
                    n=n-2;
                    break;
                }
            }
        }
        String ret = sb.toString();
        return ret;*/
    }
}
