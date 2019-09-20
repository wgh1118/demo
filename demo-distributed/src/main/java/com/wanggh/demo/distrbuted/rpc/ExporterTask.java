package com.wanggh.demo.distrbuted.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

public class ExporterTask implements Runnable {

    private Socket client;

    public ExporterTask(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            objectInputStream = new ObjectInputStream(client.getInputStream());
            String interfaceName = objectInputStream.readUTF();
            String methodName = objectInputStream.readUTF();
            Class<?> service = Class.forName(interfaceName);
            Class<?>[] parameterTypes = (Class<?>[]) objectInputStream.readObject();
            Class<?>[] arguments = (Class<?>[]) objectInputStream.readObject();
            Method method = service.getMethod(methodName, parameterTypes);
            Object result = method.invoke(service.newInstance(), arguments);
            objectOutputStream = new ObjectOutputStream(client.getOutputStream());
            objectOutputStream.writeObject(result);
        } catch (IOException | ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
