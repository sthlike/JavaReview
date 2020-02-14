/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.java.review.singleton;

public enum EnumSingleton {
    INSTANCE;

    public void print() {
        System.out.println("singleton using enum");
    }
}
