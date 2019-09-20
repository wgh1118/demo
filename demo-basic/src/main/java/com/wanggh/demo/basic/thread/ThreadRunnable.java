package com.wanggh.demo.basic.thread;

/**
 * 接口继承
 *
 * @author wanggh
 */
public class ThreadRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("线程名称:" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadRunnable basicThread = new ThreadRunnable();
        System.out.println("开始");
        Thread thread = new Thread(basicThread, "测试线程");
        thread.start();
        System.out.println("线程名称:" + Thread.currentThread().getName());
        System.out.println("结束");
    }
}
