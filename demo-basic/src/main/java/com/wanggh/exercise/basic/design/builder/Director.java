package com.wanggh.exercise.basic.design.builder;

public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    //产品构建与组装方法
    public Product construct() {
        return builder.buildPartA().buildPartB().buildPartC().getResult();
    }
}