package com.wanggh.exercise.distrbuted.rpc;

public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String s) {
        return s;
    }
}
