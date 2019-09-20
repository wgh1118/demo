package com.wanggh.demo.basic.thread.multi;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.currentThread;

/**
 * @author wanggh
 */
public class MyList {
    private List<String> lst = new ArrayList<>();

    synchronized public void add(String name) {
        System.out.println(currentThread().getName() + "---------add开始");
        lst.add(name);
        System.out.println("长度-----" + lst.size());
        System.out.println(currentThread().getName() + "---------add结束");
    }

    synchronized public int getSize() {
        return lst.size();
    }

}
