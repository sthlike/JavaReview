/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.java.review.thread.lock.sequence;

public class WrongBankAccount {
    private final String id;
    private double amount;


    public WrongBankAccount(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    /**
     * 没有考虑to是动态变化的情况，仅按固定的顺序加锁，会造成死锁。
     *
     * @param to
     * @param amount
     */
    public void transfer(WrongBankAccount to, double amount) {
        synchronized (this) {
            System.out.println("lock from in thread "
                    + Thread.currentThread().getId());
            synchronized (to) {
                System.out.println("lock to in thread "
                        + Thread.currentThread().getId());
                this.amount -= amount;
                to.amount += amount;
            }
        }
    }
}
