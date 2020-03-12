/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.distribution.lock.multi;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.exception.ZkNodeExistsException;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ZkLockWithSort extends ZkAbstrackLock {
    private static final String LOCK_PATH = "/lockWithSort";
    private String currentPath;
    private String prePath;
    private CountDownLatch latch;

    public ZkLockWithSort() {
        try {
            zkClient.createPersistent(LOCK_PATH);
        } catch (ZkNodeExistsException e) {
            System.out.println(LOCK_PATH + " is already existed");
        }
    }

    @Override
    protected boolean tryLock() {
        if (currentPath == null || currentPath.length() <= 0) {
            currentPath = zkClient.createEphemeralSequential(LOCK_PATH + "/", null);
        }
        List<String> children = zkClient.getChildren(LOCK_PATH);
        Collections.sort(children);
        if (currentPath.equals(LOCK_PATH + "/" + children.get(0))) {
            System.out.printf("path:%s got lock\n", currentPath);
            return true;
        } else {
            int sequence = Collections.binarySearch(children, currentPath.substring(LOCK_PATH.length() + 1));
            prePath = LOCK_PATH + "/" + children.get(sequence - 1);
        }
        System.out.printf("path:%s wait pre:%s\n", currentPath, prePath);
        return false;
    }

    @Override
    protected void await() {
        IZkDataListener dataListener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                if (latch != null) {
                    System.out.printf("path:%s deleted\n", s);
                    latch.countDown();
                }
            }
        };
        zkClient.subscribeDataChanges(prePath, dataListener);
        if (zkClient.exists(prePath)) {
            latch = new CountDownLatch(1);
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        zkClient.unsubscribeDataChanges(prePath, dataListener);
    }

    @Override
    public void unLock() {
        zkClient.delete(currentPath);
        zkClient.close();
        System.out.printf("path:%s lock released\n", currentPath);
    }
}
