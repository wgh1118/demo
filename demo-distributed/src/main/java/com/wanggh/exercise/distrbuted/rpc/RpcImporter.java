package com.wanggh.exercise.distrbuted.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

public class RpcImporter<T> {
    public T importer(final Class<?> serverClass, final InetSocketAddress address) {
        //noinspection unchecked
        return (T) Proxy.newProxyInstance(serverClass.getClassLoader(), new Class<?>[]{serverClass.getInterfaces()[0]}, (proxy, method, args) -> {
            Socket socket = null;
            ObjectOutputStream objectOutputStream = null;
            ObjectInputStream objectInputStream = null;
            try {
                socket = new Socket();
                socket.connect(address);
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeUTF(serverClass.getName());
                objectOutputStream.writeUTF(method.getName());
                objectOutputStream.writeObject(method.getParameterTypes());
                objectOutputStream.writeObject(args);
                objectInputStream = new ObjectInputStream(socket.getInputStream());
                return objectInputStream.readObject();
            } finally {
                if (socket != null) {
                    socket.close();
                }
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            }
        });
    }
}
