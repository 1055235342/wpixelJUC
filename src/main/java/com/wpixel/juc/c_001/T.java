package com.wpixel.juc.c_001;

public class T {

    //synchronized

    private int count = 0;
    private Object o = new Object();

    public void m(){
        synchronized (o) {
            count ++;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }
    public void m1(){
        synchronized (this) {
            count ++;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

    public synchronized void m2(){
        count ++;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        T t = new T();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                t.m();
            }).start();
        }
    }
}
