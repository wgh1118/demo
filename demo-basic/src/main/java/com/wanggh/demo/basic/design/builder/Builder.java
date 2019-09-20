package com.wanggh.demo.basic.design.builder;

interface Builder {
    Builder buildPartA();

    Builder buildPartB();

    Builder buildPartC();

    Product getResult();
}