package com.wanggh.demo.basic.thread.wait;

public class PcTest {
    public static void main(String[] args) {
        String lock = new String("");
        Produce produce = new Produce(lock);
        Consume consume = new Consume(lock);
        ThreadProduce threadProduce = new ThreadProduce(produce);
        ThreadConsume threadConsume = new ThreadConsume(consume);
        threadConsume.start();
        threadProduce.start();
    }
}
