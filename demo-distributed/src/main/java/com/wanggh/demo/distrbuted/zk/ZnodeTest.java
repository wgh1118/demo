package com.wanggh.demo.distrbuted.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * watcher为一次性注册，每次处理完状态，需要重新注册
 *
 * @author wanggh
 */
public class ZnodeTest implements Watcher {
    ZooKeeper zooKeeper;
    /**
     * -1，匹配所有版本号
     */
    static int version = -1;

    private CountDownLatch connectedSemaphore = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        ZnodeTest znodeTest = new ZnodeTest();
        znodeTest.connect();
        znodeTest.delete();
        znodeTest.create();

        znodeTest.get();
        znodeTest.set();

        znodeTest.delete();
        znodeTest.close();

    }

    void connect() {
        try {
            zooKeeper = new ZooKeeper("localhost:2181", 1000, this);
            connectedSemaphore.await();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    void close() {
        try {
            if (zooKeeper != null) {
                zooKeeper.close();
                System.out.println("连接断开");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void create() {
        try {
            zooKeeper.create("/root", "root".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    void set() {
        try {
            zooKeeper.setData("/root", "root-1".getBytes(), version);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    void delete() {
        try {
            if (zooKeeper.exists("/root", false) != null) {
                zooKeeper.delete("/root", version);
            }
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    void get() {
        try {
            Stat stat = new Stat();
            byte[] bytes = zooKeeper.getData("/root", true, stat);
            String s = new String(bytes);
            System.out.println(s);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    void exists() {
        try {
            Stat stat = zooKeeper.exists("/root", false);
            System.out.println(stat == null);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        Event.KeeperState keeperState = watchedEvent.getState();
        if (keeperState == Event.KeeperState.SyncConnected) {
            if (watchedEvent.getType() == Event.EventType.None) {
                System.out.println("连接成功");
                connectedSemaphore.countDown();
            }
            if (watchedEvent.getType() == Event.EventType.NodeDeleted) {
                System.out.println("删除");
            }
            if (watchedEvent.getType() == Event.EventType.NodeChildrenChanged) {
                System.out.println("字节点改变");
            }
            if (watchedEvent.getType() == Event.EventType.NodeCreated) {
                System.out.println("创建");
            }
            if (watchedEvent.getType() == Event.EventType.NodeDataChanged) {
                System.out.println("数据修改");
            }
        }
    }
}

