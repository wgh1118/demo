package com.wanggh.demo.basic.thread.wait;

public class Consume {
    private String lock;

    public Consume(String lock) {
        this.lock = lock;
    }

    public void getValue() {
        try {
            synchronized (lock) {
                if ("".equals(ValueObj.value)) {
                    lock.wait();
                }
                System.out.println("GetValue----->" + ValueObj.value);
                ValueObj.value = "";
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
