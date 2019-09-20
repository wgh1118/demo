package com.wanggh.exercise.basic.thread.stop;

/**
 * 判断线程是否停止isInterrupted()
 * interrupt()只是给线程作停止标记
 * interrupted();
 *
 * @author wanggh
 */
public class ThreadInterrupted extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            System.out.println("i=" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new ThreadInterrupted();
        thread.start();
        Thread.sleep(1000L);
        thread.interrupt();
        System.out.println("停止1?:" + thread.isInterrupted());
        System.out.println("停止2?:" + thread.isInterrupted());
    }
}

