package com.wanggh.demo.basic.thread.wait;

public class ThreadConsume extends Thread {
    private Consume consume;

    public ThreadConsume(Consume consume) {
        this.consume = consume;
    }

    @Override
    public void run() {
        while (true) {
            consume.getValue();
        }
    }
}
