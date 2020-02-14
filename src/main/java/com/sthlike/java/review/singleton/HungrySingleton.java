/*
 * Copyright (c) sthlike.com 2020.
 */
package com.sthlike.java.review.singleton;

public class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return instance;
    }

    public void print() {
        System.out.println("hungry singleton");
    }
}
