/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.distribution.lock.single;

import java.util.concurrent.atomic.AtomicInteger;

public class GenUniqueID {
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                System.out.println(SequenceID.getSequence());
            }).start();
        }
    }

    private static class SequenceID {
        private static AtomicInteger sequence = new AtomicInteger(0);

        public static int getSequence() {
            return sequence.addAndGet(1);
        }
    }

}
