/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.sort;

import java.util.Arrays;

public class Merge1 implements Sortable {
    @Override
    public void sort(int[] ints) {
        int[] temp = merge(Arrays.copyOfRange(ints, 0, ints.length / 2),
                Arrays.copyOfRange(ints, ints.length / 2, ints.length));

        for (int i = 0; i < ints.length; i++) {
            ints[i] = temp[i];
        }
    }

    private int[] merge(int[] left, int[] right) {
        if (left.length > 1) {
            left = merge(Arrays.copyOfRange(left, 0, left.length / 2),
                    Arrays.copyOfRange(left, left.length / 2, left.length));
        }
        if (right.length > 1) {
            right = merge(Arrays.copyOfRange(right, 0, right.length / 2),
                    Arrays.copyOfRange(right, right.length / 2, right.length));
        }
        int[] temp = new int[left.length + right.length];
        int indexLeft = 0, indexRight = 0;
        while (indexLeft != left.length && indexRight != right.length) {
            if (left[indexLeft] <= right[indexRight]) {
                temp[indexLeft + indexRight] = left[indexLeft];
                indexLeft++;
            } else {
                temp[indexLeft + indexRight] = right[indexRight];
                indexRight++;
            }
        }
        if (indexLeft < left.length) {
            for (int i = indexLeft; i < left.length; i++) {
                temp[i + indexRight] = left[i];
            }
        }

        if (indexRight < right.length) {
            for (int i = indexRight; i < right.length; i++) {
                temp[indexLeft + i] = right[i];
            }
        }
        return temp;
    }
}
