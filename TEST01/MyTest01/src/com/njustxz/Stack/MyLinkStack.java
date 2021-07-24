package com.njustxz.Stack;

/**
 * 通过链表实现栈，
 * 栈的top指针指向链表的头节点
 * 内部类Node实现链表
 */
public class MyLinkStack implements MyStack {
    int size;
    private Node top;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public void push(Object e) {
        //
        Node pNode = new Node(e, top);
        top = pNode;
        size++;
    }

    @Override
    public Object pop() {
        if (size < 1) {
            throw new StackOverflowError("栈空了！！");
        }
        Object res = top.data;
        top = top.next;
        size--;
        return res;
    }

    @Override
    public Object peak() {
        if (size < 1) {
            throw new StackOverflowError("栈空了！！");
        }
        return top.data;
    }

    @Override
    public String toString() {
        Node pNode = top;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(pNode.data);
            pNode = pNode.next;
            sb.append(",");
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]");
        return sb.toString();
    }

    private class Node {
        Object data;
        Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
