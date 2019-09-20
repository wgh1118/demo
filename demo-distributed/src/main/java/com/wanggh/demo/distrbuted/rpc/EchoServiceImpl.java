package com.wanggh.demo.distrbuted.rpc;

public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String s) {
        return s;
    }
}
