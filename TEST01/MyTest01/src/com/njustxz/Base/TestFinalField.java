package com.njustxz.Base;

public class TestFinalField {
    public final static int para1;
    public final int para2;
    final double para3;
    final double para4;
    static{
        para1=5;
    }
    {
        para2 = 5;
    }

    public TestFinalField(double para3, double para4) {
        this.para3 = para3;
        this.para4 = para4;
    }

    public final void out(){
        System.out.println("输出的是无参方法");
    }
    public void out(String str){
        System.out.println("输出："+str);
    }

    public static void main(String[] args) {
        TestFinalField tff = new TestFinalField(2.1,3.4);
        System.out.println(tff.getClass());
        tff.out();
        tff.out("11223");
    }
}
