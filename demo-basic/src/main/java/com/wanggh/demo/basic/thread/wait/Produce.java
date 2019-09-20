package com.wanggh.demo.basic.thread.wait;

public class Produce {
    private String lock;

    public Produce(String lock) {
        this.lock = lock;
    }

    public void setValue() {
        try {
            synchronized (lock) {
                if (!"".equals(ValueObj.value)) {
                    lock.wait();
                }
                String value = String.valueOf(System.currentTimeMillis());
                System.out.println("SetValue------>" + value);
                ValueObj.value = value;
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
