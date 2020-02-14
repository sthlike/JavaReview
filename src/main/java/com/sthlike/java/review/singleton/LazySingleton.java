/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.java.review.singleton;

public class LazySingleton {
    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        return LazySingletonHolder.instance;
    }

    public void print() {
        System.out.println("lazy singleton");
    }

    private static class LazySingletonHolder {
        private static final LazySingleton instance = new LazySingleton();
    }
}
