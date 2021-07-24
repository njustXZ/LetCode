package com.njustxz.Stack;

/**
 * ClassName:MyLinkStackTest
 * Package:com.njustxz.Stack
 * Description:
 *
 * @Date: 2020/11/20  20:39
 * @Author: XZH-njust
 */
public class MyLinkStackTest {
    public static void main(String[] args) {
        MyStack myStack = new MyLinkStack();
        System.out.println(myStack.isEmpty());
        System.out.println(myStack.getSize());
        System.out.println(myStack);
        myStack.push("gg");
        myStack.push("jj");
        myStack.push("dd");
        myStack.push("mm");
        System.out.println(myStack);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack);
        System.out.println(myStack.peak());
        System.out.println(myStack.pop());
        System.out.println(myStack.peak());
        System.out.println(myStack);
    }
}
