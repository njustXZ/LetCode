package com.njustxz.MeiTuan;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String tmp = in.nextLine();
            String[] tmps = tmp.split(" ");
            int[] s1 = new int[tmps.length];
            for (int i = 0;i<tmps.length;i++) {
                s1[i] = Integer.parseInt(tmps[i]);
                System.out.println(tmps[i]);
            }
            tmp = in.nextLine();
            tmps = tmp.split(" ");
            int[] s2 = new int[tmps.length];
            for (int i = 0; i < tmps.length; i++) {
                s2[i] = Integer.parseInt(tmps[i]);
                System.out.println(tmps[i]);
            }

        }
    }

    public static int getM(int[] s1,int[] s2){
        if(s1.length !=3 || s2.length!=s1[0]) return -1;
        int n = s1[0],x = s1[1],y = s1[2];
        if(2*x>n || 2*y<n) return -1;
        List<Integer> lists = new LinkedList<>();
        for (int value : s2) {
            lists.add(value);
        }
        Collections.sort(lists);
        return 0;

    }
}
