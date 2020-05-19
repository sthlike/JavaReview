/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.sort;

public class Insertion implements Sortable {
    @Override
    public void sort(int[] ints) {
        for (int i = 1; i < ints.length; i++) {
            int preLen = i;
            for (int j = preLen; j > 0; j--) {
                if (ints[j] < ints[j - 1]) {
                    Utils.swap(ints, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }
}
