/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.java.review.singleton;

public class DoubleCheckSingleton {
    private static volatile DoubleCheckSingleton instance;

    private DoubleCheckSingleton() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static DoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                System.out.printf("thread:%d,DCS:%s\n",
                        Thread.currentThread().getId(),
                        DoubleCheckSingleton.getInstance());
            }).start();
        }
    }
}
