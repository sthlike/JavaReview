/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.distribution.lock.multi;

public interface ZkLock {

    public void lock();

    public void unLock();
}
