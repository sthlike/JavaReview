/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.java.review.thread.lock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ShowReadWriteLock {
    private static ReadWrite readWrite = new ReadWrite();

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new WriteRunnable()).start();
            for (int j = 0; j < 10; j++) {
                new Thread(new ReadRunnable()).start();
            }
        }
    }

    private static class ReadRunnable implements Runnable {

        @Override
        public void run() {
            int total = readWrite.getTotal();
        }
    }

    private static class WriteRunnable implements Runnable {

        @Override
        public void run() {
            int random = new Random().nextInt(100);
            readWrite.setTotal(random);
        }
    }

    private static class ReadWrite {
        private final ReadWriteLock lock = new ReentrantReadWriteLock();
        private final Lock readLock = lock.readLock();
        private final Lock writeLock = lock.writeLock();

        private int total;

        public int getTotal() {
            long start = System.currentTimeMillis();
            readLock.lock();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.printf("the total is %d and get total in %d ms\n",
                        total, System.currentTimeMillis() - start);
                readLock.unlock();
            }
            return this.total;
        }

        public void setTotal(int total) {
            long start = System.currentTimeMillis();
            writeLock.lock();
            try {
                Thread.sleep(10);
                this.total = total;
                System.out.printf("set total %d in %d ms\n",
                        total, System.currentTimeMillis() - start);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                writeLock.unlock();
            }
        }
    }
}
