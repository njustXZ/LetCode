package com.njustxz.ArrayList;

/**
 * ClassName:MyArrayListTest
 * Package:com.njustxz
 * Description:
 *
 * @Date: 2020/11/10  10:09
 * @Author: XZH-njust
 */
public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList list1 = new MyArrayList();
        System.out.println(list1.isEmpty());
        System.out.println(list1.getSize());

        list1.insert(0,"aa");
        list1.insert(1,"bb");
        list1.insert(2,"cc");
        list1.insert(2,"ee");
        list1.insert(2,"ff");

        System.out.println(list1.toString());

        System.out.println(list1.indexOf("cc"));
        System.out.println(list1.contains("ff"));
        System.out.println(list1.contains("op"));

        list1.remove("ds");
        System.out.println(list1.toString());
        list1.remove("ee");
        System.out.println(list1.toString());
    }
}
