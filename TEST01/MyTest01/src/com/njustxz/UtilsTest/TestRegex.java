package com.njustxz.UtilsTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
    public static void main(String[] args) {
        String s1 = "hello my deal friends!!";
        String s2 =s1.replaceAll(" ",
                " =w= ");
        System.out.println(s1);
        System.out.println(s2);

        //匹配电话号码：
        Pattern p1 = Pattern.compile("1[345789][1-9][0-9]{8}");
        Matcher m = p1.matcher("13620153053");
        System.out.println(m.matches());

        //邮箱匹配
        String RegEx = "";
    }
}
