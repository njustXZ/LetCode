package com.njustxz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Student01 {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int len = nums1.length;
        ArrayList<Integer> nums3 = new ArrayList<>();
        ArrayList<Integer> nums4 = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int tmp = Math.max(nums1[i]-nums2[i],nums2[i]-nums1[i]);
            nums3.add(tmp);
            nums4.add(tmp);
        }
        Collections.sort(nums4,(a,b)->b-a);
        return 0;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums1 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            nums1.add(i);
        }
        Collections.sort(nums1,(a,b)-> b-a);
        System.out.println(nums1);
    }
}
