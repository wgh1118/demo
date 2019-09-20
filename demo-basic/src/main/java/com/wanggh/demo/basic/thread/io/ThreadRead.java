package com.wanggh.demo.basic.thread.io;

import java.io.PipedInputStream;

public class ThreadRead extends Thread {

    private ReadData readData;
    private PipedInputStream pipedInputStream;

    public ThreadRead(ReadData readData, PipedInputStream pipedInputStream) {
        this.readData = readData;
        this.pipedInputStream = pipedInputStream;
    }

    @Override
    public void run() {
        readData.readMethod(pipedInputStream);
    }
}
