/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.recursive;

public class Hano {
    public static void move(char a, char b, char c, int n) {
        if (n > 0) {
            move(a, c, b, n - 1);
            System.out.println(a + "->" + c);
            move(b, a, c, n - 1);
        }
    }

    public static void main(String[] args) {
        move('A', 'B', 'C', 3);
    }
}
