package com.wanggh.demo.basic.thread.wait;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        ThreadA threadA = new ThreadA(lock);
        ThreadB threadB = new ThreadB(lock);
        threadA.start();
        Thread.sleep(50L);
        threadB.start();
    }
}
