package com.wanggh.demo.basic.design.singleton;

/**
 * 静态内部类
 * 静态内部类方式在Singleton类被装载时并不会立即实例化，而是在需要实例化时，调用getInstance方法，
 * 才会装载SingletonInstance类，从而完成Singleton的实例化。
 * 类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM帮助我们保证了线程的安全性，在类进行初始化时，别的线程是无法进入的。
 * 优点：避免了线程不安全，延迟加载，效率高。
 *
 * @author wanggh
 */
public class StaticInnerSingleton {
    private static class Singleton {
        private static final StaticInnerSingleton INSTANCE = new StaticInnerSingleton();
    }

    public static StaticInnerSingleton getInstance() {
        return Singleton.INSTANCE;
    }
}
