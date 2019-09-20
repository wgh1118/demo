package com.wanggh.exercise.basic.design.builder;

interface Builder {
    Builder buildPartA();

    Builder buildPartB();

    Builder buildPartC();

    Product getResult();
}