package com.njustxz.ClassLoader;


import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class TestLoader {
    public static void main(String[] args) throws IOException {
        ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统加载器："+systemLoader);

        Enumeration<URL> eml = systemLoader.getResources("");
        while(eml.hasMoreElements()){
            System.out.println(eml.nextElement());
        }
        ClassLoader extensionLoader = systemLoader.getParent();
        System.out.println("拓展加载器"+extensionLoader);
        System.out.println("拓展类加载器的加载路径："+System.getProperty("java.ext.dirs"));
        System.out.println("拓展类的parent："+extensionLoader.getParent());
    }
}
