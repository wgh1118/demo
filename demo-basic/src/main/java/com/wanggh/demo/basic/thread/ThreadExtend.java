package com.wanggh.demo.basic.thread;

/**
 * 继承
 *
 * @author wanggh
 */
public class ThreadExtend extends Thread {

    public ThreadExtend() {
        this.setName("测试线程");
    }

    @Override
    public void run() {
        super.run();
        System.out.println("this.getName():" + this.getName());
        System.out.println("currentThread().getName():" + currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println("开始");
        Thread thread = new ThreadExtend();
        thread.start();
        System.out.println("线程名称:" + Thread.currentThread().getName());
        System.out.println("结束");
    }
}
