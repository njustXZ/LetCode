package com.njustxz.IO;

import java.io.DataOutput;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class IOTest1 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("E:\\Java算法\\数据结构\\TEST01\\MyTest01\\src\\com\\njustxz\\Test.java");
        byte[] buff = new byte[4096];
        System.out.println(new String(buff,0,fis.read(buff)));
        fis.close();
    }
}
class TestIO2{
    public static void main(String[] args) {
        try(FileReader fr= new FileReader("props.txt")) {

            char[] cbuf = new char[32];
            int hasRead = 0;
            while ((hasRead = fr.read(cbuf)) > 0) {
                System.out.print(cbuf);
                Thread.sleep(100);
            }
        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
}
