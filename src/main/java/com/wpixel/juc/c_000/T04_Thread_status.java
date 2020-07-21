package com.wpixel.juc.c_000;

public class T04_Thread_status {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread();
        System.out.println(t1.getState()); //NEW
        t1.start();
        System.out.println(t1.getState()); //RUNNABLE
        t1.join();
        System.out.println(t1.getState()); //TERMINATED
    }
}
