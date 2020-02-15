/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.java.review.thread.lock.sequence;

public class BankAccount {
    private static final Object tieLock = new Object();
    private final String id;
    private volatile double amount;

    public BankAccount(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    /**
     * 根据对象原始的HashCode来判断顺序后进行锁定，当Hash冲突时借助一个联合锁来保证顺序。
     * 如果对象本身有唯一的标识，如ID，也可用ID进行顺序判断，确保相等情况可免去联合锁。
     *
     * @param to
     * @param amount
     */
    public void transfer(BankAccount to, double amount) {
        //int fromHash = System.identityHashCode(this);
        //int toHash = System.identityHashCode(to);
        int fromHash = this.id.hashCode();//为演示HashCode冲突时的处理
        int toHash = to.id.hashCode();//为演示HashCode冲突时的处理
        if (fromHash < toHash) {
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
        } else if (fromHash > toHash) {
            synchronized (to) {
                System.out.println("lock to in thread "
                        + Thread.currentThread().getId());
                synchronized (this) {
                    System.out.println("lock from in thread "
                            + Thread.currentThread().getId());
                    this.amount -= amount;
                    to.amount += amount;
                }
            }
        } else {
            synchronized (tieLock) {
                System.out.println("tie lock in thread "
                        + Thread.currentThread().getId());
                synchronized (this) {
                    System.out.println("tie lock from in thread "
                            + Thread.currentThread().getId());
                    synchronized (to) {
                        System.out.println("tie lock to in thread "
                                + Thread.currentThread().getId());
                        this.amount -= amount;
                        to.amount += amount;
                    }
                }
            }
        }
    }

    public double getAmount() {
        return this.amount;
    }
}
