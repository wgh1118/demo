package com.wanggh.demo.basic.design.builder;

public class ConcreteBuilder implements Builder {

    private Product product = new Product();

    @Override
    public Builder buildPartA() {
        product.setPartA("建造 PartA");
        return this;
    }

    @Override
    public Builder buildPartB() {
        product.setPartA("建造 PartB");
        return this;
    }

    @Override
    public Builder buildPartC() {
        product.setPartA("建造 PartC");
        return this;
    }

    @Override
    public Product getResult() {
        return this.product;
    }
}