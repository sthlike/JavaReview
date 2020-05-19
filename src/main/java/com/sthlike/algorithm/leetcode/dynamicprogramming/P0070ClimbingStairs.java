/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/climbing-stairs/
 * <p>
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class P0070ClimbingStairs {

    public static void main(String[] args) {
        P0070ClimbingStairs cs = new P0070ClimbingStairs();
        System.out.println(cs.climbStairs(6));
        System.out.println(cs.climbStairs1(6));
    }

    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int[] step = new int[n];
        step[0] = 1;
        step[1] = 2;
        for (int i = 2; i < n; i++) {
            step[i] = step[i - 1] + step[i - 2];
        }
        return step[n - 1];
    }

    public int climbStairs1(int n) {
        if (n < 3) {
            return n;
        }
        int before1 = 2, before2 = 1;
        for (int i = 2; i < n; i++) {
            int current = before1 + before2;
            before2 = before1;
            before1 = current;
        }
        return before1;
    }

}
