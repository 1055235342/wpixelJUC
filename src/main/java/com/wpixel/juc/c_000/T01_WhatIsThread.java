package com.wpixel.juc.c_000;

import java.util.concurrent.TimeUnit;

public class T01_WhatIsThread {

    private static class T1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.MICROSECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new T1().start();
        for (int i = 0; i < 10; i++) {
            TimeUnit.MICROSECONDS.sleep(1);
            System.out.println("main");
        }
    }

}
