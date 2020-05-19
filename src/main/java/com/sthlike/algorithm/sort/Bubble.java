/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.sort;

public class Bubble implements Sortable {

    @Override
    public void sort(int[] ints) {
        for (int i = 0; i < ints.length - 1; i++) {
            for (int j = 0; j < ints.length - 1; j++) {
                if (ints[j] > ints[j + 1]) {
                    Utils.swap(ints, j + 1, j);
                }
            }
        }
    }
}
