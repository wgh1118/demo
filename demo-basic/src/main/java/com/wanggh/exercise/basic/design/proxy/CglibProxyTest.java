package com.wanggh.exercise.basic.design.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyTest {
    public static void main(String[] args) {
        CglibSingerProxy cglibSingerProxy = new CglibSingerProxy();
        Singer singer = (Singer) cglibSingerProxy.CreatProxyObj(Singer.class);
        singer.sing();
    }

}

class CglibSingerProxy implements MethodInterceptor {

    public Object CreatProxyObj(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("收钱");
        //执行目标对象的方法
        return proxy.invokeSuper(obj, args);
    }

}

