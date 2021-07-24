package com.njustxz.Stack;

/**
 * 定义接口，定义接口的操作
 */
public interface MyStack {
    int getSize();
    boolean isEmpty();
    void push(Object e);
    Object pop();
    Object peak();  //返回栈顶元素
}
