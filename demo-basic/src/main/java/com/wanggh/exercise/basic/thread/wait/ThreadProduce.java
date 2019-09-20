package com.wanggh.exercise.basic.thread.wait;

public class ThreadProduce extends Thread {
    private Produce produce;

    public ThreadProduce(Produce produce) {
        this.produce = produce;
    }

    @Override
    public void run() {
        while (true) {
            produce.setValue();
        }
    }
}
