package com.wanggh.exercise.basic.thread.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Test {
    public static void main(String[] args) throws IOException {
        WriteData writeData = new WriteData();
        ReadData readData = new ReadData();

        PipedInputStream pipedInputStream = new PipedInputStream();
        PipedOutputStream pipedOutputStream = new PipedOutputStream();

        pipedOutputStream.connect(pipedInputStream);

        ThreadRead threadRead = new ThreadRead(readData, pipedInputStream);
        ThreadWrite threadWrite = new ThreadWrite(writeData, pipedOutputStream);

        threadRead.start();
        threadWrite.start();

    }
}
