package com.njustxz.ArrayList;

/**
 * ClassName:MySingleLinkTest
 * Package:com.njustxz
 * Description:
 *
 * @Date: 2020/11/10  15:49
 * @Author: XZH-njust
 */
public class MySingleLinkTest {
    public static void main(String[] args) {
        MySingleLink linkList = new MySingleLink();
        System.out.println(linkList.isEmpty());
        System.out.println(linkList.getSize());

        linkList.insert(0,"hh");
        linkList.insert(0,"ff");
        linkList.insert(1,"hg");
        linkList.insert(1,"33");
        linkList.insert(4,"uu");
        System.out.println(linkList);

        System.out.println(linkList.indexOf("33"));
        System.out.println(linkList.indexOf("35"));
        System.out.println(linkList.contains("hh"));
        System.out.println(linkList.contains("hg"));

/*        System.out.println(linkList.remove(4));
        System.out.println(linkList.remove(null));
        System.out.println(linkList.remove("ff"));
        System.out.println(linkList);*/
        System.out.println(linkList.get(0));
        System.out.println(linkList.replace(2,"fg"));
        System.out.println(linkList);

        System.out.println(linkList.insertBefore("fg","aa"));
        System.out.println(linkList.insertAfter("uu","nn"));
        System.out.println(linkList);
    }
}
