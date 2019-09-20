package com.wanggh.exercise.basic.thread.io;

import java.io.IOException;
import java.io.PipedOutputStream;

public class WriteData {
    public void writeMethod(PipedOutputStream outputStream) {
        try {
            System.out.println("write:");
            for (int i = 0; i < 10; i++) {
                String s = "" + (i + 1);
                System.out.print(s);
                outputStream.write(s.getBytes());
            }
            System.out.println();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
