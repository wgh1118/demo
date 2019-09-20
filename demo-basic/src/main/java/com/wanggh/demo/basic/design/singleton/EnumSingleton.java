package com.wanggh.demo.basic.design.singleton;

/**
 * 枚举
 *
 * @author wanggh
 */
public enum EnumSingleton {
    INSTANCE;

    public EnumSingleton getInstance() {
        return INSTANCE;
    }
}