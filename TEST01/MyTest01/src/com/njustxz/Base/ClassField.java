package com.njustxz.Base;

public class ClassField{
    public static void main(String[] args) {
        A a1 = null;
        System.out.println(A.a);
        A.out();
    }
}
class A{
    public static int a = 1;
    public static void out(){
        System.out.println("类方法执行了！！！");
    }
}