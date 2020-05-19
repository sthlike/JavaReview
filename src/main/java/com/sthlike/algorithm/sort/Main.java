/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.sort;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] ints = makeInts();
        Sortable sort = new Bubble();
        sort.sort(ints);
        printInts(ints);

        ints = makeInts();
        sort = new Selection();
        sort.sort(ints);
        printInts(ints);

        ints = makeInts();
        sort = new Insertion();
        sort.sort(ints);
        printInts(ints);

        ints = makeInts();
        sort = new Merge1();
        sort.sort(ints);
        printInts(ints);

        ints = makeInts();
        sort = new Merge2();
        sort.sort(ints);
        printInts(ints);

        ints = makeInts();
        sort = new Quick();
        sort.sort(ints);
        printInts(ints);

        ints = makeInts();
        sort = new Heap();
        sort.sort(ints);
        printInts(ints);

        ints = makeInts();
        sort = new Shell();
        sort.sort(ints);
        printInts(ints);

        ints = makeInts();
        sort = new Counting();
        sort.sort(ints);
        printInts(ints);

        ints = makeInts();
        sort = new Radix();
        sort.sort(ints);
        printInts(ints);

        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(1000));
        }
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list.toString());

    }

    private static int[] makeInts() {
        return new int[]{1, 3, 2, 9, 3, 8, 90, 23, 45, 2, 2};
    }

    private static void printInts(int[] ints) {
        System.out.println(Arrays.toString(ints));
    }
}
