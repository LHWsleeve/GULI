package com.sleeve.zk.demo;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author Sleeve
 * @version 1.0
 * @date 2020/11/15 16:29
 */
public class ZkDemo {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper = getZooKeeper();
//        System.out.println(zooKeeper.getData("/atguigu", false, new Stat()));
//        String path = zooKeeper.create("/atguigu/sleeve", "xxxxx".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//        System.out.println(path);
        //查看状态
        Stat exists = zooKeeper.exists("/atguigu/sleeve", false);
        System.out.println(exists);

        zooKeeper.delete("/atguigu/sleeve", exists.getVersion());

        if (zooKeeper!=null){
            zooKeeper.close();
        }
    }


    private static ZooKeeper getZooKeeper() throws IOException, InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ZooKeeper zooKeeper = new ZooKeeper("192.168.144.128:2181", 300000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("触发监听，连接成功");
                countDownLatch.countDown();
            }
        });
        countDownLatch.await();
        return zooKeeper;
    }
}
