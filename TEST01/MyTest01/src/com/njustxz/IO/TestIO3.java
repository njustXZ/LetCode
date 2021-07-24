package com.njustxz.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class TestIO3 {
    public static void main(String[] args) {
        try(
                FileInputStream fis = new FileInputStream("test.ini");
                FileOutputStream fos = new FileOutputStream("testCopy.ini"))
        {
            byte[] buff = new byte[32];
            int hasRead = 0;
            while((hasRead=fis.read(buff))>=0){
                fos.write(buff,0,hasRead);
                System.out.println(new String(buff,0,hasRead));
                Thread.sleep(500);
            }
        }catch (IOException|InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}

class TestIO4{
    public static void main(String[] args) {
        try(FileWriter fw = new FileWriter("诗.txt")){
            fw.write("锦瑟-李商隐\r\n");
            fw.write("锦瑟无端五十弦。一线一柱思华年。\r\n");
            fw.write("庄生晓梦迷蝴蝶，望帝春心托杜鹃。\r\n");
            fw.write("沧海月明珠有泪，蓝天日暖玉升烟。\r\n");
            fw.write("此情可待成追忆，只是当时已惘然。\r\n");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
