package com.wanggh.demo.basic.thread.multi;

public class MyListTest {
    public static void main(String[] args) {
        MyList lst = new MyList();
        ThreadListA threadListA = new ThreadListA(lst);
        ThreadListB threadListB = new ThreadListB(lst);
        threadListA.setName("A");
        threadListB.setName("B");
        threadListA.start();
        threadListB.start();
    }
}
