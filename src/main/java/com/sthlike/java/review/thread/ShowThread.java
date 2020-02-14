/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.java.review.thread;

public class ShowThread {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.setPriority(5);
        t.setName("t");
        t.start();
    }

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
