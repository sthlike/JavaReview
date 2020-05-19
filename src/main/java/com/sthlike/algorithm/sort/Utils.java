/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.sort;

public class Utils {

    public static void insert(int[] ints, int srcIndex, int destIndex) {
        int temp = ints[srcIndex];
        for (int i = srcIndex; i > destIndex; i--) {
            swap(ints, i - 1, i);
        }
        ints[destIndex] = temp;
    }

    public static void swap(int[] ints, int one, int another) {
        int temp = ints[one];
        ints[one] = ints[another];
        ints[another] = temp;
    }
}
