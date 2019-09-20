package com.wanggh.exercise.distrbuted.rpc;

import java.io.IOException;
import java.net.InetSocketAddress;

@SuppressWarnings("AlibabaAvoidManuallyCreateThread")
public class Test {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                RpcExporter.exporter("127.0.0.1", 8000);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        RpcImporter<EchoService> importer = new RpcImporter<>();
        EchoService echoService = importer.importer(EchoServiceImpl.class, new InetSocketAddress("127.0.0.1", 8000));
        System.out.println(echoService.echo("1234545"));
    }
}
