package com.njustxz.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class TestMap {
    public static void main(String[] args) {
        Map<Integer,Integer> m1 = new HashMap<>();
        m1.put(1,23);
        m1.put(null,null);
        m1.put(8,23);
        m1.put(6,7);

        Set<Entry<Integer, Integer>> s1 = m1.entrySet();
        for(Entry e1:s1){
            System.out.println(e1.getKey()+"->"+e1.getValue());
        }
        m1.forEach((k,v)-> System.out.println(k+":"+v));
    }
}
class TestProperties{
    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        props.setProperty("username","root");
        props.setProperty("passwd","root123");
        props.setProperty("driver","mysql");
        props.store(new FileOutputStream("test.ini"),"comment line");
        Properties prop2 = new Properties();
        prop2.setProperty("path","src");
        prop2.load(new FileInputStream("test.ini"));
        System.out.println(prop2);
    }
}
