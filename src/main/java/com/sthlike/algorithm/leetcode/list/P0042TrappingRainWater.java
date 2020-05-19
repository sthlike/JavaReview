/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.algorithm.leetcode.list;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 * Given n non-negative integers representing an elevation map
 * where the width of each bar is 1, compute how much water
 * it is able to trap after raining.
 * <p>
 * <p>
 * The above elevation map is represented by array
 * [0,1,0,2,1,0,1,3,2,1,2,1]. In this case,
 * 6 units of rain water (blue section) are being trapped.
 * Thanks Marcos for contributing this image!
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class P0042TrappingRainWater {
    private static int trap1(int[] height) {
        int length = height.length;
        if (height == null || length < 3) {
            return 0;
        }
        int[] maxLeft = new int[length];
        int[] maxRight = new int[length];
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                maxLeft[0] = height[0];
                maxRight[length - 1] = height[length - 1];
            } else {
                maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
                maxRight[length - 1 - i] = Math.max(maxRight[length - i], height[length - 1 - i]);
            }
        }
        int total = 0;
        System.out.println(Arrays.toString(maxLeft));
        System.out.println(Arrays.toString(height));
        System.out.println(Arrays.toString(maxRight));
        for (int i = 0; i < length; i++) {
            total += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return total;
    }

    public static void main(String[] args) {
        int[] stairs = new int[]{1, 2, 1, 0, 1, 3, 1, 2};
        System.out.println(trap1(stairs));
        System.out.println(trap(stairs));
    }

    private static int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int total = 0, maxLeft = 0, maxRight = 0;
        int leftIndex = 0, rightIndex = height.length - 1;

        while (leftIndex < rightIndex) {
            System.out.println(leftIndex + "|" + rightIndex + "|" + maxLeft + "|" + maxRight);
            if (height[leftIndex] <= height[rightIndex]) {
                maxLeft = Math.max(maxLeft, height[leftIndex]);
                total += maxLeft - height[leftIndex];
                leftIndex++;
            } else {
                maxRight = Math.max(maxRight, height[rightIndex]);
                total += maxRight - height[rightIndex];
                rightIndex--;
            }
        }
        return total;
    }
}
