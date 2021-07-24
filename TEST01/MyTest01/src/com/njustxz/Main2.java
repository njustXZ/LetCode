package com.njustxz;

import java.util.*;
public class Main2{
    public static void main(String []args){
        Scanner sca = new Scanner(System.in);
        while(sca.hasNext()){
            List<Integer> nums = new LinkedList<>();
            int n = sca.nextInt();
            int h = sca.nextInt();
            int u = sca.nextInt();
            for(int i = 0;i<n;i++){
                int tmp = sca.nextInt();
                addList(nums,tmp);
            }
            int ret =0;
            while(h<u){
                h += nums.get(ret);
                ret++;
            }
            System.out.println(ret);
        }
    }
    public static void addList(List<Integer> nums,int num){
        int n = nums.size();
        for(int i =0;i<n;i++){
            if(num>nums.get(i)){
                nums.add(i,num);
                return;
            }
        }
        nums.add(num);
    }
}


class Main3{
    public static void main(String[] args){
        Scanner sca = new Scanner(System.in);
        while(sca.hasNext()){
            int n = sca.nextInt();
            int[] todo = new int[n];
            for(int i=0;i<n;i++){
                todo[i] = sca.nextInt();
            }
            List<LinkedList<Integer>> groups = new LinkedList<LinkedList<Integer>>();
            LinkedList<Integer> list1 = new LinkedList<>();
            groups.add(list1);
            LinkedList<Integer> list2 = new LinkedList<>();
            groups.add(list2);
            LinkedList<Integer> list3 = new LinkedList<>();
            groups.add(list3);
            LinkedList<Integer> list4 = new LinkedList<>();
            groups.add(list4);
            LinkedList<Integer> list5 = new LinkedList<>();
            groups.add(list5);
            list1.add(100);
            for (int i = 0; i < n; i++) {
                groups.get(todo[i]-1).add(0,i+1);
                if(groups.get(0).isEmpty() ||groups.get(1).isEmpty()||groups.get(2).isEmpty()||groups.get(3).isEmpty()||groups.get(4).isEmpty()){
                    System.out.println(-1);
                }else{

                    System.out.print(groups.get(0).remove(0)+" ");
                    System.out.print(groups.get(1).remove(0)+" ");
                    System.out.print(groups.get(2).remove(0)+" ");
                    System.out.print(groups.get(3).remove(0)+" ");
                    System.out.println(groups.get(4).remove(0)+" ");
                }
            }
        }
    }
}
class Main4{
    public static void main(String[] args){
        Scanner sca = new Scanner(System.in);
        while(sca.hasNext()){
            int n1 = sca.nextInt();
            int n2 = sca.nextInt();
            int n = sca.nextInt();
            int[] boys = new int[n];
            for(int i = 0;i<n;i++){
                boys[i] = sca.nextInt();
            }
            List<Integer> l1 = new LinkedList<>();
            List<Integer> l2 = new LinkedList<>();
            List<Integer> l3 = new LinkedList<>();
            List<Integer> l4 = new LinkedList<>();
            for(int i = 0;i<n1;i++){
                l1.add(i + 1);
                l3.add(i + 1);
            }
            for(int i = 0;i<n2;i++){
                l2.add(i+n1+1);
                l4.add(i+n1+1);
            }
            boolean flag = true;
            for(int boy:boys){
                if(boy>n1){
                    int tmp = boy - 1 - n1;
                    l1.add(l4.get(tmp));
                    Iterator it = l1.iterator();
                    while(it.hasNext()){
                        int tar = (int) it.next();
                    }
                }else{
                    int tmp = boy -1;
                    l2.add(l3.get(tmp));
                    flag = l1.remove(l3.get(tmp));
                }
            }
            for(int num :l1){
                System.out.print(num+" ");
            }
            System.out.println();
            for(int num :l2){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}