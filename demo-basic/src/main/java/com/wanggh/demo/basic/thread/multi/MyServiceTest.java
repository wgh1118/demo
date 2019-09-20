package com.wanggh.demo.basic.thread.multi;

public class MyServiceTest {
    public static void main(String[] args) throws InterruptedException {
        MyList lst = new MyList();
        ThreadServiceA threadServiceA = new ThreadServiceA(lst);
        ThreadServiceA threadServiceB = new ThreadServiceA(lst);
        threadServiceA.setName("A");
        threadServiceB.setName("B");
        threadServiceA.start();
        threadServiceB.start();
        Thread.sleep(6000L);
        System.out.println("长度----" + lst.getSize());
    }
}
