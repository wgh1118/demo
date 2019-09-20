package com.wanggh.demo.basic.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyTest {
    public static void main(String[] args) {
        SingerProxy singerProxy = new SingerProxy();
        singerProxy.setTarget(new Singer());
        Star star1 = (Star) singerProxy.CreatProxyObj();
        star1.sing();
    }
}

interface Star {
    String sing();

}

class Singer implements Star {
    @Override
    public String sing() {
        System.out.println("给我一杯忘情水");
        return "唱完";
    }
}

class SingerProxy implements InvocationHandler {
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("收钱");
        Object r = method.invoke(target, args);
        return r;
    }

    public Object CreatProxyObj() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}