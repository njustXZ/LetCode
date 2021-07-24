package com.njustxz.ArrayList;

/**
 * 自定义用来实现双向链表的
 * 使用内部类Node实现节点，使用对象引用表示指向前后节点的操作
 * 链表中经常会有针对头尾元素的操作
 */
public class MyDualLinkList implements MyList {
    private Node first;
    private Node last;
    private int size;

    //获取元素数目
    @Override
    public int getSize() {
        return size;
    }

    //判断链表是否为空
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //插入元素
    @Override
    public void insert(int i, Object e) {
        //检查是否越界，在哪个位置添加元素
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException(i + "越界了！！");
        }
        if (i == 0) {
            addFirst(e);

        } else if (i == size) {
            addLast(e);
        } else {
            Node pNode = getNode(i);
            Node prevNode = pNode.prev;
            Node newNode = new Node(e, prevNode, pNode);
            prevNode.next = newNode;
            pNode.prev = newNode;
        }
        size++;
    }

    //返回对应索引值的节点
    private Node getNode(int i) {
        Node pNode = first;
        for (int j = 0; j < i; j++) {
            pNode = pNode.next;
        }
        return pNode;
    }

    //在链表尾部添加元素
    private void addLast(Object e) {
        Node newNode = new Node(e, last, null);
        last = newNode;
        Node pNode = last.prev;
        pNode.next = last;
    }

    //在头部添加元素e
    private void addFirst(Object e) {
        Node newNode = new Node(e, null, first);
        first = newNode;
        Node pNode = first.next;
        if (pNode == null) {
            last = newNode;
        } else {
            pNode.prev = first;
        }
    }

    //判断链表中是否包含指定的元素
    @Override
    public boolean contains(Object e) {
        return indexOf(e) >= 0;
    }

    //判断元素e在链表中第一次出现的位置
    @Override
    public int indexOf(Object e) {
        //一次遍历链表中各个元素，判断节点元素是否与e相同
        int i = 0;
        if (e == null) {
            for (Node pNode = first; pNode != null; pNode = pNode.next) {
                if (pNode.data == null) {
                    return i;
                }
                i++;
            }
        } else {
            for (Node pNode = first; pNode != null; pNode = pNode.next) {
                if (pNode.data.equals(e)) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    @Override
    public Object remove(Object e) {
        int index = indexOf(e);
        if (index < 0) {
            return null;
        }
        return remove(index);
    }

    @Override
    public Object remove(int i) {
        //判断索引值是否越界
        if (i < 0 || i > size - 1) {
            throw new IndexOutOfBoundsException(i + "越界了");
        }
        Node pNode = getNode(i);
        Node prevNode = pNode.prev;
        Node nextNode = pNode.next;

        if (prevNode == null) {
            first = nextNode;
        } else {
            prevNode.next = nextNode;
        }

        if (nextNode == null) {
            last = prevNode;
        } else {
            nextNode.prev = prevNode;
        }
        return pNode.data;
    }

    @Override
    public Object replace(int i, Object e) {
        //判断索引是否超出范围
        Node pNode = getNode(i);
        Object oldDate = pNode.data;
        pNode.data = e;
        return oldDate;
    }

    @Override
    public Object get(int i) {
        return null;
    }

    @Override
    public boolean insertBefore(Object p, Object e) {
        int i = indexOf(p);
        if (i < 0) {
            return false;
        }
        insert(i, e);
        return true;
    }

    @Override
    public boolean insertAfter(Object p, Object e) {
        int i = indexOf(p);
        if (i < 0) {
            return false;
        }
        insert(i + 1, e);
        return true;
    }

    private class Node {
        Object data;
        Node prev;
        Node next;

        public Node(Object data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        //遍历各个节点，返回各个节点上的数据
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Node node = first; node != null; node = node.next) {
            sb.append(node.data);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");

        return sb.toString();
    }
}
