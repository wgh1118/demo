package com.wanggh.demo.basic.thread;

/**
 * 线程并不会停止，会继续执行->System.out.println("线程没有停止");
 *
 * @author wanggh
 */
public class ThreadStop extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            if (this.isInterrupted()) {
                System.out.println("线程停止");
                break;
            }
            System.out.println("i=" + i);
        }
        System.out.println("线程没有停止");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new ThreadStop();
        thread.start();
        Thread.sleep(1000L);
        thread.interrupt();
    }
}
