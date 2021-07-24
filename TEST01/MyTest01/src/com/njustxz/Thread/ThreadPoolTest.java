package com.njustxz.Thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(2,2,0L,
                                                        TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5)
                                                        ,new ThreadPoolExecutor.DiscardOldestPolicy());
         int index = 0;
        Runnable target = ()->{
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread().getName()+"->"+i);
            }
        };
        for (int i = 0; i < 2; i++) {
            tpe.execute(target);
        }
        tpe.shutdown();
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "---->"+i);
        }
        tpe.execute(target);
    }
}
