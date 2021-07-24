package com.njustxz.Thread;

import com.njustxz.Base.TestEnum;

import javax.xml.transform.Source;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestThread {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
            if(i==20){
                new FirstThread().start();
                new FirstThread().start();
            }
        }
    }
}

class FirstThread extends Thread{
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println(this.getName()+"->"+i);
        }
    }
}

class TestThread2 implements Runnable{
    //共享了i，可能会出错
    private int i=0;
    @Override
    public void run() {
        for(;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"->"+i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"->"+i);
            if(i==20){
                TestThread2 tt2 = new TestThread2();
                new Thread(tt2,"新线程1").start();
                new Thread(tt2,"新线程2").start();
                new Thread(()->{
                    for (int j = 0; j < 20; j++) {
                        System.out.println(Thread.currentThread().getName()+"---"+j);
                    }
                },"新线程3").start();
            }
        }
    }
}
class TestThread3{
    public static void main(String[] args) {
        FutureTask<Integer> task = new FutureTask<Integer>(()->{
            int i = 0;
            for(;i<100;i++){
                System.out.println(Thread.currentThread().getName()+" 的循环变量i的值："+i);
            }
            return i;
        });
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"-->"+i);
            if(i==20){
                new Thread(task,"有返回值的线程").start();
            }
        }
        try{
            System.out.println("子线程返回的值："+task.get());
        }catch (ExecutionException | InterruptedException e){
            e.printStackTrace();
        }
    }
}


