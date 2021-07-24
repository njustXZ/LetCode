package com.njustxz.Base;

import java.util.*;

public class TestList {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(9);
        l1.add(13);
        l1.add(26);
        l1.add(92);
        l1.add(45);
        l1.add(19);
        System.out.println(l1);
        l1.sort((o1, o2) ->(o2-o1));
        System.out.println(l1);
        l1.sort(Comparator.comparingInt(o -> o));
        System.out.println(l1);

        Collections.sort(l1,(o1, o2) -> o2-o1);
        System.out.println(l1);
    }
}
