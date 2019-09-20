package com.wanggh.exercise.basic.thread.multi;

public class MyService {
    public MyList add(MyList lst, String s) {
        if (lst.getSize() < 1) {
            try {
                // 这里是异步执行，所以list长度为1
                // 解决方案 lst.add添加synchronized代码块,synchronized(lst)
                // eg:下面注释代码
                lst.add(s);
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        return lst;
    }

    // public MyList add(MyList lst, String s) {
    //     synchronized (lst) {
    //         if (lst.getSize() < 1) {
    //             try {
    //                 // 这里是异步执行，所以list长度为1
    //                 // 解决方案 lst.add添加synchronized代码块,synchronized(lst)
    //                 lst.add(s);
    //                 Thread.sleep(2000L);
    //             } catch (InterruptedException e) {
    //                 e.printStackTrace();
    //             }
    //
    //         }
    //     }
    //
    //     return lst;
    // }
}
