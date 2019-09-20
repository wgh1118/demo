package com.wanggh.demo.basic.design.factory.abs;

public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}