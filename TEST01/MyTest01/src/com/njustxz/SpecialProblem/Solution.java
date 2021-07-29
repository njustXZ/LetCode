package com.njustxz.SpecialProblem;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 这个类和包主要用于解决一些经典的算法问题
 * 例如，约瑟夫环问题，七皇后问题等
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> l1=solution.Josephu(0,3,5);
        System.out.println(l1);
    }


    /**
     * 约瑟夫环问题：
     * (自己做出现的问题：1.没有实例，在letCode中找了一下，面试题62和这题类似；
     *                  2.第n个小孩，在相加的时候，是加多少呢？)
     * @param k 从哪个小孩开始
     * @param m 树多少个数
     * @param n 共有多少小孩
     */
    public List<Integer> Josephu(int k, int m, int n){
        if(k>n) return null;
        List<Integer> ret = new ArrayList<>();
        List<String> boys = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            boys.add(i+1+"");
        }
        for (int i = 0; i < n-1; i++) {
            k=(k+m-1)%(n-i);
            ret.add(Integer.parseInt(boys.remove(k)));
        }
        ret.add(Integer.parseInt(boys.remove(0)));
        return ret;
    }

    /**
     * 逆波兰表达式解决简单计算器的问题
     * 将中缀表达式转成后缀表达式
     */
    public double polandExpression(String str1){
        int preIndex = 0;
        int endIndex = 0;
        if(str1 == null || str1.length()==0){
            return 0;
        }
        int n = str1.length();
        LinkedList<Integer> ansStack=new LinkedList<>();
        LinkedList<Character> optStack = new LinkedList<>();
        
        return 0.0;
    }
}
