package com.wanggh.exercise.basic.thread.multi;

public class ThreadListB extends Thread {
    private MyList list;

    public ThreadListB(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            list.add("threadB" + (i + 1));
        }
    }
}
