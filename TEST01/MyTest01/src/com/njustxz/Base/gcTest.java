package com.njustxz.Base;

public class gcTest {
    public static void main(String[] args) {
        for(int i=0;i<4;i++){
            new gcTest();
            //System.gc();
            Runtime.getRuntime().gc();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("系统正在把我清理了");
    }
}
