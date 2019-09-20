package com.wanggh.demo.basic.thread.wait;

/**
 * @author wanggh
 */
public class ThreadB extends Thread {
    private Object lock;

    public ThreadB(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        super.run();
        try {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    MyList.add(i + "");
                    if (MyList.size() == 5) {
                        lock.notify();
                        System.out.println("发出通知");
                    }
                }
                Thread.sleep(1000L);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
