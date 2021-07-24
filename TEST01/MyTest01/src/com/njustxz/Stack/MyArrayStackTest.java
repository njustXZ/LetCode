package com.njustxz.Stack;

/**
 * ClassName:MyArrayListTest
 * Package:com.njustxz.Stack
 * Description:
 *
 * @Date: 2020/11/20  19:54
 * @Author: XZH-njust
 */
public class MyArrayStackTest {
    public static void main(String[] args) {
        MyStack myStack = new MyArrayStack(3);
        System.out.println(myStack.getSize());
        System.out.println(myStack.isEmpty());
        myStack.push("gg");
        myStack.push("jj");
        myStack.push("dd");
        myStack.push("mm");
        System.out.println(myStack.getSize());
        System.out.println(myStack.isEmpty());
        System.out.println(myStack);

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.peak());
        System.out.println(myStack.pop());
        System.out.println(myStack);
        System.out.println(myStack.pop());



    }
}
