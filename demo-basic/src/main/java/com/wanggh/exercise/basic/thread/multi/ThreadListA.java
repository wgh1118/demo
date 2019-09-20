package com.wanggh.exercise.basic.thread.multi;

public class ThreadListA extends Thread {
    private MyList list;

    public ThreadListA(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            list.add("threadA" + (i + 1));
        }
    }
}
