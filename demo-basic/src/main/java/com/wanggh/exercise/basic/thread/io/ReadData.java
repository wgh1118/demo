package com.wanggh.exercise.basic.thread.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class ReadData {
    public void readMethod(PipedInputStream pipedInputStream) {
        try {
            System.out.println("read:");
            byte[] bytes = new byte[20];
            int len;
            while ((len = pipedInputStream.read(bytes)) != -1) {
                String s = new String(bytes, 0, len);
                System.out.print(s);
            }
            System.out.println();
            pipedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
