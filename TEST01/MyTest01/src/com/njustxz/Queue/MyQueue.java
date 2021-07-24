package com.njustxz.Queue;

import java.util.Arrays;

/**
 * 数组队列的存储实现
 */
public class MyQueue {
    private Object[] elements;
    public static final int DEFAULT_CAPACITY = 8;
    private int front;
    private int rear;
    private int size;

    public MyQueue() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyQueue(int capacity) {
        elements = new Object[capacity];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //入队
    public void enQueue(Object e) {
        //假设队列已满，对数组扩容
        if (size >= elements.length) {
            expendQueue();
        }
        elements[rear] = e;
        rear = (rear + 1) % elements.length;
        size++;
    }

    //出队
    public Object deQueue() {
        if (size <= 0) {
            //抛出一个队列为空的异常
            throw new QueueEmptyException("队列空了！！");
        }
        Object old = elements[front];
        front = (front + 1) % elements.length;
        size--;
        return old;
    }

    public Object peak() {
        if (size <= 0) {
            throw new QueueEmptyException("队列空了！！");

        }
        return elements[front];
    }

    private void expendQueue() {
        /*Object[] newElements = new Object[elements.length * 2];
        for (int i = front; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        for (int i = 0; i < front; i++) {
            newElements[i+elements.length] =elements[i];
        }
        elements = newElements;*/
        Object[] newElements = new Object[elements.length * 2];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[front];
            front = (front + 1) % elements.length;
        }
        elements = newElements;
        front = 0;
        rear = size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int point = front;
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[point]);
            sb.append(",");
            point = (point+1)%elements.length;
        }
        if(sb.length()>2){
            sb.deleteCharAt(sb.length()-1);
        }
        sb.append("]");
        return sb.toString();
    }
}
