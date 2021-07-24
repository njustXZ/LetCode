package com.njustxz.ArrayList;

/**
 * ClassName:MyArrayList
 * Package:com.njustxz
 * Description:
 * 通过数组实现链表
 *
 * @Date: 2020/11/10  9:03
 * @Author: XZH-njust
 */
public class MyArrayList implements MyList {

    private Object[] elements;
    private static final int DEFAULT_CAPACITY = 16;
    private int size;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        elements = new Object[initialCapacity];
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void insert(int i, Object e) {
        //是否越界
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException(i + "越界 !!");
        }
        //是否满了
        if (size >= elements.length) {
            expandSpace();      //数组扩容
        }
        //从最后一个元素开始
        for (int j = size; j > i; j--) {
            elements[j] = elements[j - 1];
        }
        elements[i] = e;
        size++;
    }

    //数组扩容,定义一个更大的数组，把原来的数据复制到新的数组，让原来的数组名指向新的数组
    public void expandSpace() {
        Object[] newElements = new Object[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    //判断线性表中是否包含元素e
    @Override
    public boolean contains(Object e) {
        //通过判断元素的索引是否大于0来判断
        return indexOf(e) >= 0;
    }

    //返回元素在线性表中第一次出现的索引值，不存在则返回-1
    @Override
    public int indexOf(Object e) {
        //遍历数组，调用equals方法，元素不能为空
        //但是数组内可能有元素为空，所以，还需判断是否为空
        if (e == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
            return -1;
        }
        for (int i = 0; i < size; i++) {
            if (e.equals(elements[i])) {
                return i;
            }
        }

        return -1;
    }

    //删除线性表中第一个与e向的元素
    @Override
    public Object remove(Object e) {
        int index = indexOf(e);
        if (index < 0) {
            return null;
        }
        return remove(index);
    }

    //删除指定索引值的元素
    @Override
    public Object remove(int i) {
        //涉及到索引值
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException(i + "越界 !!");
        }
        Object ret = elements[i];
        //把i+1往后的元素依次往前移
        for (int j = i; j < size - 1; j++) {
            elements[j] = elements[j + 1];
        }
        //最后的元素设置为null
        elements[size - 1] = null;
        //修改元素的个数
        size--;
        return ret;
    }

    @Override
    public Object replace(int i, Object e) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException(i + "越界！！");
        }
        Object Old = elements[i];
        elements[i] = e;
        return Old;
    }

    @Override
    public Object get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException(i + "越界！！");
        }
        return elements[i];
    }

    @Override
    public boolean insertBefore(Object p, Object e) {
        if (indexOf(e) < 0) {
            return false;
        }
        insert(indexOf(e), p);
        return true;
    }

    @Override
    public boolean insertAfter(Object p, Object e) {
        if (indexOf(e) < 0) {
            return false;
        }
        insert(indexOf(e) + 1, p);
        return true;
    }

    //重写toString

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < size; i++) {
            builder.append(elements[i]);
            builder.append(",");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }
}
