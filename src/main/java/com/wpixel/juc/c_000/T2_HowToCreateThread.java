package com.wpixel.juc.c_000;

public class T2_HowToCreateThread {

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("MyThread");
        }
    }

    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("MyRun");
        }
    }

    //启动线程的三种方式： 1、Thread 2、Runnable 3、Executors.newCachedThread
    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyRun()).start();
        new Thread(() -> System.out.println("()")).start();
    }
}
