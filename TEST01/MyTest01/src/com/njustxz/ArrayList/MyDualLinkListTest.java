package com.njustxz.ArrayList;

/**
 * 测试双向链表
 */
public class MyDualLinkListTest {
    public static void main(String[] args) {
        //创建双向链表
        MyDualLinkList linkList = new MyDualLinkList();

        System.out.println(linkList.getSize());
        System.out.println(linkList.isEmpty());

        linkList.insert(0,"gg");
        linkList.insert(0,"jj");
        linkList.insert(1,"dd");
        linkList.insert(3,"mm");
        System.out.println(linkList);

        System.out.println(linkList.contains("jj"));
        System.out.println(linkList.contains("xx"));
        System.out.println(linkList.indexOf("dd"));
        System.out.println(linkList.indexOf("DD"));

        System.out.println(linkList.remove(0));
        System.out.println(linkList);
        System.out.println(linkList.remove("gg"));
        System.out.println(linkList);

        System.out.println(linkList.replace(0,"ghs"));
        System.out.println(linkList);

        System.out.println(linkList.insertBefore("ghs","lsp"));
        System.out.println(linkList.insertAfter("ghs","awsl"));
        System.out.println(linkList);
    }
}
