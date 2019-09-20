package com.wanggh.exercise.basic.thread.wait;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanggh
 */
public class MyList {
    private static List<String> list = new ArrayList<>();

    static void add(String s) {
        list.add(s);
    }

    static int size() {
        return list.size();
    }
}
