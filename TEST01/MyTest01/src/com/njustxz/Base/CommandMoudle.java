package com.njustxz.Base;

public class CommandMoudle {
    public void process(int[] target,Command cmd){
        cmd.process(target);
    }

    public static void main(String[] args) {
        CommandMoudle cm = new CommandMoudle();
        int[] array = {12,16,5,45,89,3};
        cm.process(array,new AddCommand());
        cm.process(array,new ShowCommand());
        cm.process(array, new Command() {
            //输出最小元素
            @Override
            public void process(int[] target) {
                if(target==null||target.length==0){
                    System.out.println("输入数组异常");
                }else {
                    int min = target[0];
                    for (int tmp : target) {
                        if (tmp < min) {
                            min = tmp;
                        }
                    }
                    System.out.println("最小元素是：" + min);
                }
            }
        });
        cm.process(array,target->{
            if(target==null||target.length==0){
                System.out.println("输入数组异常");
                return;
            }
            int max = target[0];
            for(int tmp:target){
                if(tmp>max){
                    max = tmp;
                }
            }
            System.out.println("最大元素是："+max);
        });
    }
}
@FunctionalInterface
interface Command {

    void process(int[] target);
    default int add(int a,int b){
        return a+b;
    }
    private int minus(int a,int b){
        return a-b;
    }
}
class ShowCommand implements Command{
    @Override
    public void process(int[] target) {
        for(int i:target){
            System.out.print(i+" ，");
        }
        System.out.println();
    }
}
class AddCommand implements Command{
    @Override
    public void process(int[] target) {
        int sum =0;
        for(int i:target){
            sum+=i;
        }
        System.out.println("数组和未："+sum);
    }
}
class Test extends Thread{

    @Override
    public void run() {

    }
}
