/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.java.review.thread.lock.sequence;

public class ShowCorrectLockSequence {
    public static void main(String[] args) {
        testSequence();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testAnotherSequence();
    }

    private static void testAnotherSequence() {
        AnotherBankAccount anotherFrom = new AnotherBankAccount("12345", 500);
        AnotherBankAccount anotherTo = new AnotherBankAccount("54321", 300);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                anotherFrom.transfer(anotherTo, 10);
            }).start();
            new Thread(() -> {
                anotherTo.transfer(anotherFrom, 20);
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(anotherFrom.getAmount());
        System.out.println(anotherTo.getAmount());
    }

    private static void testSequence() {
        BankAccount from = new BankAccount("12345", 500);
        BankAccount to = new BankAccount("54321", 300);
        BankAccount to2 = new BankAccount("12345", 400);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                from.transfer(to, 10);
            }).start();
            new Thread(() -> {
                to.transfer(from, 20);
            }).start();
            new Thread(() -> {
                from.transfer(to2, 10);
            }).start();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(from.getAmount());
        System.out.println(to.getAmount());
        System.out.println(to2.getAmount());
    }
}
