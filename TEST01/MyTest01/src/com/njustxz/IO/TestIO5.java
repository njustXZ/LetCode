package com.njustxz.IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class TestIO5 {
    public static void main(String[] args) {
        try(
                FileOutputStream fos = new FileOutputStream("诗.txt");
                PrintStream ps = new PrintStream(fos)
        ){
            ps.println("普通字符串");
            ps.println(new TestIO5());
        }catch (IOException e){
            e.printStackTrace();
        }
                        }
}
