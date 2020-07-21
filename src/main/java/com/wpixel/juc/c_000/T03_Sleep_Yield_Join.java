package com.wpixel.juc.c_000;

import java.util.concurrent.TimeUnit;

public class T03_Sleep_Yield_Join {


    public static void main(String[] args) {
        testJoin();
    }

    static void sleep(){
        new Thread( () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("A" + i);
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    static void testYield(){
        new Thread( () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("A" + i);
                if (i % 10 == 0) Thread.yield();
            }
        } ).start();

        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("B" + i);
                if (i % 10 == 0) Thread.yield();
            }
        }).start();
    }

    static void testJoin() {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("B" + i);
                if (i % 10 == 0) Thread.yield();
            }
        });

        new Thread(()->{
            try {
                System.out.println(111);
                t1.join();
                System.out.println(222);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        t1.start();
    }
}
