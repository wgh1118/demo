package com.wanggh.exercise.basic.thread;

/**
 * 线程变量共享安全
 *
 * @author wanggh
 */
public class ThreadVarShareSync extends Thread {
    private Integer count = 5;

    @Override
    synchronized public void run() {
        super.run();
        count--;
        System.out.println(currentThread().getName() + ":" + count);
    }

    public static void main(String[] args) {
        ThreadVarShareSync threadVarShare = new ThreadVarShareSync();
        Thread thread1 = new Thread(threadVarShare, "A");
        Thread thread2 = new Thread(threadVarShare, "B");
        Thread thread3 = new Thread(threadVarShare, "C");
        Thread thread4 = new Thread(threadVarShare, "D");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
