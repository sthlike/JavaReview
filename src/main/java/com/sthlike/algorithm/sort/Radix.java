/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.sort;

import java.util.LinkedList;
import java.util.Queue;

public class Radix implements Sortable {

    @Override
    public void sort(int[] ints) {
        int max = ints[0];
        for (int i = 0; i < ints.length; i++) {
            if (max < ints[i]) {
                max = ints[i];
            }
        }

        int step = String.valueOf(max).length();
        Queue<Integer>[] queues = new Queue[10];
        for (int i = 0; i < 10; i++) {
            queues[i] = new LinkedList<>();
        }
        for (int i = 0; i < step; i++) {
            int pow = (int) Math.pow(10, i);
            for (int j = 0; j < ints.length; j++) {
                int radix = ints[j] / pow % 10;
                queues[radix].add(ints[j]);
            }
            int index = 0;
            for (int j = 0; j < queues.length; j++) {
                int curLen = queues[j].size();
                for (int k = 0; k < curLen; k++) {
                    ints[index] = queues[j].poll();
                    index++;
                }
            }
        }
    }
}
