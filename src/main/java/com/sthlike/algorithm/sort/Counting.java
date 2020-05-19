/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.sort;

public class Counting implements Sortable {
    @Override
    public void sort(int[] ints) {
        int min = ints[0];
        int max = ints[0];
        for (int i = 1; i < ints.length; i++) {
            if (min > ints[i]) {
                min = ints[i];
            }
            if (max < ints[i]) {
                max = ints[i];
            }
        }
        int[] bucket = new int[max - min + 1];
        for (int i = 0; i < ints.length; i++) {
            bucket[ints[i] - min]++;
        }
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                ints[index] = min + i;
                index++;
            }
        }
    }
}
