/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.sort;

public class Shell implements Sortable {
    @Override
    public void sort(int[] ints) {
        int initStep = (int) Math.log(ints.length);
        for (int step = initStep; step > 0; step--) {
            for (int i = step; i < ints.length; i += step) {
                int temp = ints[i];
                for (int j = i; j > 0; j -= step) {
                    if (ints[j] < ints[j - step]) {
                        Utils.insert(ints, j, j - step);
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
