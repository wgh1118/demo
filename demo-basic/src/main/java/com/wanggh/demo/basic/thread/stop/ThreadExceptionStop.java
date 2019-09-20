package com.wanggh.demo.basic.thread.stop;

/**
 * 线程停止
 *
 * @author wanggh
 */
public class ThreadExceptionStop extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 500000; i++) {
                if (this.isInterrupted()) {
                    System.out.println("线程停止");
                    throw new InterruptedException("");
                }
                System.out.println("i=" + i);
            }
            System.out.println("线程没有停止");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new ThreadExceptionStop();
        thread.start();
        Thread.sleep(1000L);
        thread.interrupt();
    }
}
