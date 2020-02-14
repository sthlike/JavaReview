/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.java.review.thread.lock.sequence;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AnotherBankAccount {
    private final Lock lock = new ReentrantLock();
    private final String id;
    private volatile double amount;

    public AnotherBankAccount(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public Lock getLock() {
        return this.lock;
    }

    /**
     * 使用类似自旋一样的方式处理，每个对象定义一个锁，用对象的锁本身进行tryLock，
     * 成功即可继续，不成功继续尝试，但需要休眠一个随机数，避免活锁的产生。
     *
     * @param to
     * @param amount
     */
    public void transfer(AnotherBankAccount to, double amount) {
        Random random = new Random();
        while (true) {
            if (this.getLock().tryLock()) {
                try {
                    System.out.println("lock from in thread "
                            + Thread.currentThread().getId());
                    if (to.getLock().tryLock()) {
                        try {
                            System.out.println("lock to in thread "
                                    + Thread.currentThread().getId());
                            this.amount -= amount;
                            to.amount += amount;
                            break;
                        } finally {
                            to.getLock().unlock();
                        }
                    } else {
                        System.out.println("lock to failed in Thread "
                                + Thread.currentThread().getId());
                    }
                } finally {
                    this.getLock().unlock();
                }
            } else {
                System.out.println("lock from failed in Thread "
                        + Thread.currentThread().getId());
            }
            try {
                Thread.sleep(random.nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public double getAmount() {
        return this.amount;
    }
}
