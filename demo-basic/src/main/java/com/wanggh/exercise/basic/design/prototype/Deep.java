package com.wanggh.exercise.basic.design.prototype;

public class Deep implements Cloneable {
    @Override
    protected Deep clone() throws CloneNotSupportedException {
        return (Deep) super.clone();
    }
}
