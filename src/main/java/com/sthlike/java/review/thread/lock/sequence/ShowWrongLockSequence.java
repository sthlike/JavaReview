/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.java.review.thread.lock.sequence;

public class ShowWrongLockSequence {
    public static void main(String[] args) {
        WrongBankAccount from = new WrongBankAccount("12345", 500);
        WrongBankAccount to = new WrongBankAccount("54321", 300);
        new Thread(() -> {
            from.transfer(to, 100);
        }).start();
        new Thread(() -> {
            to.transfer(from, 200);
        }).start();
    }
}
