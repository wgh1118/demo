package com.wanggh.demo.basic.design.prototype;

/**
 * @author wanggh
 */
public class Prototype implements Cloneable {

    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype prototype = new Prototype();
        Prototype clone = prototype.clone();
        System.out.println(prototype == clone);
    }
}
