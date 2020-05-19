/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.sort;

public class Merge2 implements Sortable {
    @Override
    public void sort(int[] ints) {
        merge(ints, 0, ints.length / 2, ints.length);
    }

    private void merge(int[] ints, int left, int middle, int right) {
        if (middle - left > 1) {
            merge(ints, left, left + (middle - left) / 2, middle);
        }
        if (right - middle > 1) {
            merge(ints, middle, middle + (right - middle) / 2, right);
        }
        int[] temp = new int[right - left];
        int indexLeft = left, indexRight = middle, indexTemp = 0;
        while (indexLeft != middle && indexRight != right) {
            if (ints[indexLeft] <= ints[indexRight]) {
                temp[indexTemp] = ints[indexLeft];
                indexLeft++;
            } else {
                temp[indexTemp] = ints[indexRight];
                indexRight++;
            }
            indexTemp++;
        }
        if (indexLeft < middle) {
            for (int i = indexLeft; i < middle; i++) {
                temp[indexTemp] = ints[i];
                indexTemp++;
            }
        }

        if (indexRight < right) {
            for (int i = indexRight; i < right; i++) {
                temp[indexTemp] = ints[i];
                indexTemp++;
            }
        }

        for (int i = 0; i < temp.length; i++) {
            ints[left + i] = temp[i];
        }
    }
}
