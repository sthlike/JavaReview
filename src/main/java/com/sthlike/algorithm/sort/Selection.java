/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.sort;

public class Selection implements Sortable {
    @Override
    public void sort(int[] ints) {
        for (int i = 0; i < ints.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[minIndex] > ints[j]) {
                    minIndex = j;
                }
            }
            Utils.swap(ints, minIndex, i);
        }
    }
}
