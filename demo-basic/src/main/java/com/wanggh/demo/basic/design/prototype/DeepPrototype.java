package com.wanggh.demo.basic.design.prototype;

/**
 *
 * @author wanggh
 */
public class DeepPrototype implements Cloneable {

    private Deep deep;

    @Override
    public DeepPrototype clone() throws CloneNotSupportedException {
        DeepPrototype deepPrototype = (DeepPrototype) super.clone();
        Deep deep = this.deep.clone();
        deepPrototype.setDeep(deep);
        return deepPrototype;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        DeepPrototype prototype = new DeepPrototype();
        DeepPrototype clone = prototype.clone();
        System.out.println(prototype == clone);
    }

    public void setDeep(Deep deep) {
        this.deep = deep;
    }
}
