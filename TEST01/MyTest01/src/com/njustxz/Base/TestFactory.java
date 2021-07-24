package com.njustxz.Base;

public class TestFactory {

    public OutPut getOutPut(){
        return new BetterPrint();
    }
    public static void main(String[] args) {
        TestFactory tf = new TestFactory();
        Computer c = new Computer(tf.getOutPut());
        c.addOut("hello!");
        c.addOut("hello!!");
        c.print();
    }
}

class Computer{
    private OutPut out;
    public Computer(OutPut out){
        this.out = out;
    }
    public void addOut(String str){
        out.getData(str);
    }
    public void print(){
        out.out();
    }
}
interface OutPut{
    void out();
    void getData(String str);
}

class Print implements OutPut{
    private String str = "";
    @Override
    public void out() {
        System.out.println(str);
        str = "";
    }

    @Override
    public void getData(String str1) {
        if(!str.isEmpty()){
            System.out.println("输出已经有内容未输出，覆盖了之前的内容。");
        }
        str = str1;
    }
}

class BetterPrint implements OutPut{
    private String[] outs = new String[10];
    private int dataNum;

    @Override
    public void out() {
        while(dataNum>0){
            System.out.println(outs[0]);
            System.arraycopy(outs,1,outs,0,--dataNum);
        }
    }

    @Override
    public void getData(String str) {
        if(dataNum>=10){
            System.out.println("输出队列已满，请先输出后再尝试！");
        }else{
            outs[dataNum++] = str;
        }
    }
}
