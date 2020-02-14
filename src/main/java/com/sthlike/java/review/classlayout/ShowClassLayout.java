/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.java.review.classlayout;

import org.openjdk.jol.info.ClassLayout;

public class ShowClassLayout {
    public static void main(String[] args) {
        System.out.println(ClassLayout.parseClass(Lock.class).toPrintable());
        Lock lock = new Lock();
        lock.hashCode();
        System.out.println(ClassLayout.parseInstance(lock).toPrintable());
        synchronized (lock) {
            System.out.println(ClassLayout.parseInstance(lock).toPrintable());
        }
    }

    public static class Lock {
        byte b;
        Ref ref;
    }

    public static class Ref {

    }
}
