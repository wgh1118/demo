package com.wanggh.demo.basic.thread.io;

import java.io.PipedOutputStream;

public class ThreadWrite extends Thread {

    private WriteData writeData;
    private PipedOutputStream pipedOutputStream;

    public ThreadWrite(WriteData writeData, PipedOutputStream pipedOutputStream) {
        this.writeData = writeData;
        this.pipedOutputStream = pipedOutputStream;
    }

    @Override
    public void run() {
        writeData.writeMethod(pipedOutputStream);
    }
}
