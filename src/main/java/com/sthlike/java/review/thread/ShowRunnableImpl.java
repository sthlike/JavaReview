/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.java.review.thread;

public class ShowRunnableImpl {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.setName("t");
        t.start();
    }

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
