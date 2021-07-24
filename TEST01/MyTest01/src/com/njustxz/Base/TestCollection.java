package com.njustxz.Base;

import java.util.Collection;
import java.util.HashSet;

public class TestCollection {
    public static void main(String[] args) {
        Collection<String> coll1 = new HashSet<>();
        coll1.add("hello");
        coll1.add("java");
        coll1.add("let's");
        coll1.add("start");
        coll1.forEach(obj-> System.out.println("迭代的元素:"+obj));

        coll1.removeIf(obj-> obj.length()<5);
        for(String s1 : coll1){
            System.out.println(s1);
        }
    }
}
