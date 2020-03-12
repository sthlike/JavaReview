/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.distribution.lock.multi;

import org.I0Itec.zkclient.IZkDataListener;

import java.util.concurrent.CountDownLatch;

public class ZkLockWithException extends ZkAbstrackLock {

    private static final String LOCK_PATH = "/lockWithException";

    private CountDownLatch latch = null;

    @Override
    protected boolean tryLock() {
        try {
            zkClient.createEphemeral(LOCK_PATH);
            return true;
        } catch (Exception e) {
            System.out.println("exception thrown and wait");
            return false;
        }
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
                    System.out.printf("%s removed\n", s);
                    latch.countDown();
                }
            }
        };
        zkClient.subscribeDataChanges(LOCK_PATH, dataListener);
        if (zkClient.exists(LOCK_PATH)) {
            latch = new CountDownLatch(1);
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        zkClient.unsubscribeDataChanges(LOCK_PATH, dataListener);
    }

    @Override
    public void unLock() {
        zkClient.delete(LOCK_PATH);
        zkClient.close();
        System.out.println("lock released");
    }
}
