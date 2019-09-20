package com.wanggh.exercise.basic.design.singleton;

/**
 * 懒汉式单例，双重检查
 * 类加载时没有生成单例，只有当第一次调用 getInstance 方法时才去创建这个单例。
 * 多线程程序，则不要删除上例代码中的关键字 volatile 和 synchronized，否则将存在线程非安全的问题。
 * 如果不删除这两个关键字就能保证线程安全，但是每次访问时都要同步，会影响性能，且消耗更多的资源。
 *
 * @author wanggh
 */
public class LazySingleton {
    /**
     * 实例
     * 保证 instance 在所有线程中同步
     */
    private static volatile LazySingleton instance = null;

    private LazySingleton() {
        //private 避免类在外部被实例化
    }

    public static synchronized LazySingleton getInstance() {
        // getInstance 方法前加同步
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
