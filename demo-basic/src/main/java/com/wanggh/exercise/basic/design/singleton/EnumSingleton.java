package com.wanggh.exercise.basic.design.singleton;

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