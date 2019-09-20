package com.wanggh.exercise.basic.thread.multi;

/**
 * @author wanggh
 */
public class ThreadServiceA extends Thread {
    private MyList list;

    public ThreadServiceA(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        super.run();
        MyService myService = new MyService();
        myService.add(list, "A");
    }
}
