package com.njustxz.Stack;

import java.util.Arrays;

/**
 * 堆栈的顺序实现
 */
public class MyArrayStack implements MyStack {

    private Object[] elements;
    private static final int DEFAULT_CAPACITY = 16; //默认容量
    private int top;

    public MyArrayStack(int num) {
        elements = new Object[num];
    }

    public MyArrayStack() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int getSize() {
        return top;
    }

    @Override
    public boolean isEmpty() {
        return top <= 0;
    }

    @Override
    public void push(Object e) {
        //判断堆栈是否已满
        if (top >= elements.length) {
            //扩容，定义一个更大的数组，把元素复制，原来的的数组名指向新的数组，默认大小为原来的两倍
            Object[] newData = new Object[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                newData[i] = elements[i];
            }
            elements = newData;
        }
        elements[top] = e;
        top++;
    }

    @Override
    public Object pop() {
        if (top <= 0) {
            throw new StackOverflowError("栈已空！！");
        }
        Object res = elements[top - 1];
        elements[top - 1] = null;
        top--;
        return res;
    }

    @Override
    public Object peak() {
        if (top <= 0) {
            throw new StackOverflowError("栈已空！！");
        }
        return elements[top - 1];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(" ");
        for (int i = 0; i < top; i++) {
            sb.append(elements[top - i - 1]);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }
}
