package com.njustxz.Queue;

/**
 * 测试队列
 */
public class TestMyQueue {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue.getSize());
        myQueue.enQueue("z");
        myQueue.enQueue("t");
        myQueue.enQueue("t");
        myQueue.enQueue("x");
        myQueue.enQueue("z");
        myQueue.enQueue("h");
        System.out.println(myQueue);
        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.deQueue();
        System.out.println(myQueue);
        System.out.println(myQueue.getSize());
        myQueue.enQueue('z');
        myQueue.enQueue('t');
        myQueue.enQueue('t');
        myQueue.enQueue('z');
        myQueue.enQueue('u');
        myQueue.enQueue('o');
        myQueue.enQueue('t');
        myQueue.enQueue('i');
        myQueue.enQueue('n');
        myQueue.enQueue('g');
        myQueue.enQueue('t');
        myQueue.enQueue('i');
        myQueue.enQueue('n');
        myQueue.enQueue('g');
        System.out.println(myQueue);
        System.out.println(myQueue.getSize());
        System.out.println(myQueue.peak());
    }
}
