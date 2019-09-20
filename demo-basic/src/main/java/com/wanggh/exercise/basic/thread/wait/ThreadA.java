package com.wanggh.exercise.basic.thread.wait;

public class ThreadA extends Thread {
    private Object lock;

    public ThreadA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        super.run();
        try {
            synchronized (lock) {
                if (MyList.size() != 5) {
                    System.out.println("start");
                    lock.wait();
                    System.out.println("end");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
