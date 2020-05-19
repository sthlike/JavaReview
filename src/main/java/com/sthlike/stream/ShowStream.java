/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShowStream {
    public static void main(String[] args) {
        int count = 1000000;
        List<Integer> list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(i);
        }

        long start = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += (list.get(i) % 3) * list.get(i) / 3;
        }
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        sum = list.stream().collect(Collectors.summingInt(i -> (i % 3) * i / 3)).intValue();
        System.out.println(sum);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(sum);
        start = System.currentTimeMillis();
        sum = list.parallelStream().collect(Collectors.summingInt(i -> (i % 3) * i / 3)).intValue();
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(sum);
    }
}
