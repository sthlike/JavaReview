/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.java.review.singleton;

public class Main {
    public static void main(String[] args) {
        LazySingleton lazySingleton = LazySingleton.getInstance();
        lazySingleton.print();
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
        hungrySingleton.print();
        EnumSingleton.INSTANCE.print();
    }
}
