/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.distribution.lock.multi;

import org.I0Itec.zkclient.ZkClient;

public abstract class ZkAbstrackLock implements ZkLock {
    private static final String ZK_HOST = "127.0.0.1:2181";

    protected ZkClient zkClient = new ZkClient(ZK_HOST);

    @Override
    public void lock() {
        if (tryLock()) {
            System.out.println("got lock");
        } else {
            await();
            lock();
        }
    }

    protected abstract boolean tryLock();

    protected abstract void await();
}
