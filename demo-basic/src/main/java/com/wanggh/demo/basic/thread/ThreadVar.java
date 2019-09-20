package com.wanggh.demo.basic.thread;

/**
 * 线程变量
 *
 * @author wanggh
 */
public class ThreadVar extends Thread {
    private Integer count = 5;

    public ThreadVar(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println(currentThread().getName() + ":" + count);
        }
    }

    public static void main(String[] args) {
        ThreadVar threadVar1 = new ThreadVar("A");
        ThreadVar threadVar2 = new ThreadVar("B");
        ThreadVar threadVar3 = new ThreadVar("C");
        threadVar1.start();
        threadVar2.start();
        threadVar3.start();
    }
}
