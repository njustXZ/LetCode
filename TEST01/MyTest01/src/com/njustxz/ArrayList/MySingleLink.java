package com.njustxz.ArrayList;

/**
 * ClassName:MySingleLink
 * Package:com.njustxz
 * Description:
 * 通过单向链表实现线性表
 *
 * @Date: 2020/11/10  11:19
 * @Author: XZH-njust
 */
public class MySingleLink implements MyList {
    //通过一个内部类实现单项链表的结点
    private class Node {
        Object data;
        Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node[" +
                    "data=" + data +
                    ']';
        }
    }

    //头部节点
    private Node head;
    private int size;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //1.头节点不存在时，需要把这个元素添加为头节点
    //2.插入位置为0，即头节点前面插入元素时
    @Override
    public void insert(int i, Object e) {
        //是否越界
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException(i + "越界！！");
        }
        //头节点是否为null
        Node newNode = new Node(e, null);
        if (head == null) {
            head = newNode;
        } else {
            //在0位置插入节点
            if (i == 0) {
                newNode.next = head;
                head = newNode;
            } else {
                //插入,需要找到前一个节点
                    Node pNode = head;
                    for (int j = 1; j < i; j++) {
                        pNode = pNode.next;
                    }
                newNode.next = pNode.next;
                pNode.next = newNode;
            }
        }
        //size
        size++;
    }

    @Override
    public boolean contains(Object e) {
        return indexOf(e) >= 0;
    }

    @Override
    public int indexOf(Object e) {
        int i = 0;
        Node pNode = head;
        if (e == null) {
            while (pNode != null) {
                if (pNode.data == null) {
                    return i;
                }
                i++;
                pNode = pNode.next;
            }
        }
        while (pNode != null) {
            if (e.equals(pNode.data)) {
                return i;
            }
            i++;
            pNode = pNode.next;
        }
        return -1;
    }

    @Override
    public Object remove(Object e) {
        int i = indexOf(e);
        if (i < 0) {
            return null;
        }
        return remove(i);
    }

    @Override
    public Object remove(int i) {
        // 是否越界,
        // 问题：指针消除就好了？
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException(i + "越界！！");
        }
        Node pNode = head;
        for (int j = 0; j < i-1; j++) {
            pNode = pNode.next;
        }
        Object res = pNode.data;
        //判断是否是第一个节点
        if(i==0){
            head = head.next;
        }
        //判断是否是最后一个元素
        if (i == (size - 1)) {
            pNode.next = null;
        } else {
            pNode.next = pNode.next.next;

        }
        //size--
        size--;
        return res;
    }

    @Override
    public Object replace(int i, Object e) {
        //是否越界
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException(i + "越界！！");
        }
        Node pNode = head;
        Node newNode = new Node(e, null);
        for (int j = 1; j < i ; j++) {
            pNode = pNode.next;
        }
        Object res = pNode.data;
        newNode.next = pNode.next.next;
        pNode.next = newNode;
        return res;
    }

    @Override
    public Object get(int i) {
        //是否越界
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException(i + "越界！！");
        }
        Node pNode = head;
        for (int j = 0; j < i; j++) {
            pNode = pNode.next;
        }
        return pNode.data;
    }

    @Override
    public boolean insertBefore(Object p, Object e) {
        int index = indexOf(p);
        if ( index< 0) {
            return false;
        }
        insert(index, e);
        return true;
    }

    @Override
    public boolean insertAfter(Object p, Object e) {
        int index=indexOf(p);
        if (index < 0) {
            return false;
        }
        insert((index + 1), e);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        Node pNode = head;
        int i=0;
        while(pNode!=null){
            builder.append("第" + i + "个：");
            builder.append(pNode.toString());
            builder.append(",");
            pNode = pNode.next;
            i++;
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("}");
        return builder.toString();
    }
}
