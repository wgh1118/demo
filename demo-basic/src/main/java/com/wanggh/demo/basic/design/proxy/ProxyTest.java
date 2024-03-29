package com.wanggh.demo.basic.design.proxy;

/**
 * 为什么需要实现接口
 * 因为使用字节码生成技术，生成的类需要继承Proxy，由于Java是单继承，与被代理的类之间联系，就才能使用接口
 *
 * @author wanggh
 */
public class ProxyTest {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.request();
    }
}

/**
 * 抽象主题
 */
interface Subject {
    /**
     *
     */
    void request();
}

/**
 * 真实主题
 */
class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("访问真实主题方法...");
    }
}

/**
 * 代理
 */
class Proxy implements Subject {
    private RealSubject realSubject;

    @Override
    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        preRequest();
        realSubject.request();
        postRequest();
    }

    private void preRequest() {
        System.out.println("访问真实主题之前的预处理。");
    }

    public void postRequest() {
        System.out.println("访问真实主题之后的后续处理。");
    }
}