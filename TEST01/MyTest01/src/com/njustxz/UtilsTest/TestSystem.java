package com.njustxz.UtilsTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.lang.Math;


public class TestSystem {
    public static void main(String[] args) throws IOException {
        Map<String,String> env = System.getenv();
        for(String name:env.keySet()){
            System.out.println(name+"------->"+env.get(name));
        }
        System.out.println("================================");
        System.out.println(System.getenv("JAVA_HOME"));
        Properties prop = System.getProperties();
        prop.store(new FileOutputStream("props.txt"),"System Properties");
        System.out.println(System.getProperty("os.name"));
    }
}

class TestRuntime{
    public static void main(String[] args) throws IOException {
        Runtime rt = Runtime.getRuntime();
        System.out.println("处理器数量"+rt.availableProcessors());
        System.out.println("内存空闲："+rt.freeMemory());
        System.out.println("最大内存："+rt.maxMemory());
        rt.exec("notepad.exe");
    }
}


