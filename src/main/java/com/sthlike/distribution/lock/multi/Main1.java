/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.distribution.lock.multi;

import java.util.concurrent.CountDownLatch;

public class Main1 {
    public static void main(String[] args) throws InterruptedException {
        int count = 100;
        CountDownLatch latch = new CountDownLatch(count);
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                new Sequence(new ZkLockWithException()).writeSequenceToFile();
                latch.countDown();
            }).start();
        }
        latch.await();
        System.out.printf("time elapsed:%d", System.currentTimeMillis() - start);
    }
}
