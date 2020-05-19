/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.sort;

import java.util.Random;

public class Quick implements Sortable {

    @Override
    public void sort(int[] ints) {
        quick(ints, 0, randomIndex(ints.length), ints.length);
    }

    private void quick(int[] ints, int left, int baseIndex, int right) {
        Utils.swap(ints, left + baseIndex, right - 1);
        int lessCount = 0;
        for (int i = left; i < right - 1; i++) {
            if (ints[i] <= ints[right - 1]) {
                Utils.insert(ints, i, lessCount + left);
                lessCount++;
            }
        }
        Utils.swap(ints, right - 1, lessCount + left);
        if (baseIndex - left > 1) {
            quick(ints, left, randomIndex(baseIndex - left), baseIndex);
        }
        if (right - baseIndex > 1) {
            quick(ints, baseIndex, randomIndex(right - baseIndex), right);
        }
    }


    private int randomIndex(int len) {
        Random random = new Random();
        return random.nextInt(len);
    }
}
