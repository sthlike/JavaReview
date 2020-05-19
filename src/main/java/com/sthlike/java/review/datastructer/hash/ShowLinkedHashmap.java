/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.java.review.datastructer.hash;

import java.util.LinkedHashMap;
import java.util.Map;

public class ShowLinkedHashmap {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        printMap(map);
        Integer x = map.remove(2);
        map.put(2, x);
        System.out.println(map.size());
        printMap(map);
    }

    private static void printMap(Map<Integer, Integer> map) {
        for (Map.Entry e : map.entrySet()) {
            System.out.println(e.getKey() + "|" + e.getValue());
        }
    }
}
