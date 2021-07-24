package com.njustxz.Base;

import javax.xml.transform.Source;
import java.io.File;
import java.io.IOException;
import java.util.Dictionary;

public class TestFile1 {
    public static void main(String[] args) {
        File file = new File(".");
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getAbsoluteFile().getParent());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());

        try {
            File tmpFile = File.createTempFile("aaa",".txt",file);
            tmpFile.deleteOnExit();
            File newFile = new File(System.currentTimeMillis()+"");
            newFile.deleteOnExit();
            System.out.println("newFile对象是否存在："+newFile.exists());
            System.out.println(newFile.createNewFile());
            System.out.println(newFile.mkdir());
            String[] fileList = file.list();
            for(String s1:fileList){
                System.out.println(s1);
            }
            File[] roots = File.listRoots();
            for(File root:roots){
                System.out.println(root);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("+++++++++++++++++++++++++++++++++++");
        File file2 = new File(".");
        String[] fileList = file.list((dir,name)->name.endsWith(".java")||new File(name).isDirectory());
        for(String s1:fileList){
            System.out.println(s1);
        }
    }
}
