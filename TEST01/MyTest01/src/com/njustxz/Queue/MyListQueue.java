package com.njustxz.Queue;

/**
 * 使用链表实现队列
 */
public class MyListQueue {
    Node front;
    Node rear;
    int size;

    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void enQueue(Object e){
        Node newNode = new Node(e,null);
        if(size==0){
            front = newNode;
            rear = newNode;
        }else{
            rear.next = newNode;
            rear = rear.next;
        }
        size++;
    }
    public Object deQueue(){
        if(size<=0){
            throw new QueueEmptyException("队列已经空了！！");
        }
        Object data = front.data;
        front = front.next;
        if(front==null){
            rear = null;
        }
        size--;
        return data;
    }

    public Object peak(){
        if(size<=0){
            throw new QueueEmptyException("队列已经空了！！");
        }
        Object data = front.data;
        return data;
    }


    private class Node{
        Object data;
        Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node pNode = front;
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(pNode.data);
            sb.append(',');
            pNode = pNode.next;
        }
        if(sb.length()>2){
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(']');
        return sb.toString();
    }
}
