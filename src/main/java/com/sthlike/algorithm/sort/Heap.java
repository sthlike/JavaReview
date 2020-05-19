/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.sort;

public class Heap implements Sortable {
    @Override
    public void sort(int[] ints) {
        int len = ints.length;
        buildMaxHeap(ints, ints.length);
        for (int i = len - 1; i > 0; i--) {
            Utils.swap(ints, 0, i);
            buildMaxHeap(ints, --len);
        }
    }

    private void buildMaxHeap(int[] ints, int len) {
        for (int i = (len - 2) / 2; i >= 0; i--) {
            adjustSubTree(ints, i, len);
        }
    }

    private void adjustSubTree(int[] ints, int index, int length) {
        int temp = ints[index];
        int leftChildIndex = leftChildIndex(index);
        int rightChildIndex = rightChildIndex(index);
        int maxChildIndex = 0;
        if (leftChildIndex >= length - 1) {
            return;
        } else if (rightChildIndex >= length - 1) {
            maxChildIndex = leftChildIndex;
        } else {
            maxChildIndex = ints[leftChildIndex(index)] > ints[rightChildIndex(index)]
                    ? leftChildIndex(index) : rightChildIndex(index);
        }
        if (ints[index] < ints[maxChildIndex]) {
            Utils.swap(ints, index, maxChildIndex);
        }
    }

    private int parent(int index) {
        return index == 0 ? 0 : (index - 1) / 2;
    }

    private int leftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int rightChildIndex(int index) {
        return 2 * index + 2;
    }
}
