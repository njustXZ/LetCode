package com.njustxz.ArrayList;

/**
 * ClassName:MyList
 * Package:com.njustxz
 * Description:
 *
 * @Date: 2020/11/10  8:22
 * @Author: XZH-njust
 */
public interface MyList {
    int getSize();
    boolean isEmpty();
    void insert(int i,Object e);
    boolean contains(Object e);
    int indexOf(Object e);
    Object remove(Object e);
    Object remove(int i);
    Object replace(int i,Object e);
    Object get(int i);
    boolean insertBefore(Object p,Object e);
    boolean insertAfter(Object p,Object e);
}
